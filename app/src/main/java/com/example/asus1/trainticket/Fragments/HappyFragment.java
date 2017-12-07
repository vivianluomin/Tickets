package com.example.asus1.trainticket.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus1.trainticket.Adapter.JokingDataApdater;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.JokeGroup;
import com.example.asus1.trainticket.Moduls.JokingData;
import com.example.asus1.trainticket.Moduls.JokingModle;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/18.
 */

public class HappyFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefresh;
    private JokingDataApdater mAdapter;
    private List<JokingData.JokingDatadata> mData = new ArrayList<>();
    private boolean isHasMore = false;
    private boolean isFresh = true;
    private boolean isGetMore = false;
    private boolean isFirt = true;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_happy,container,false);
       mRecyclerView = (RecyclerView)view.findViewById(R.id.rv_recyclerview);
       mRefresh = (SwipeRefreshLayout)view.findViewById(R.id.refresh);
       mRefresh.setRefreshing(false);
       mRefresh.setEnabled(false);
       mRefresh.setColorSchemeColors(getResources().getColor(R.color.color_red),getResources().getColor(R.color.mian_bule), Color.YELLOW);
       mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
            reqestData();
            Log.d("aaaa","fffffffff");
           }
       });

       mAdapter = new JokingDataApdater(getContext(),mData);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       mRecyclerView.setAdapter(mAdapter);

      mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
          @Override
          public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

              LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
              int fist = manager.findFirstVisibleItemPosition();
              int last = manager.findLastVisibleItemPosition();
              Log.d("poppp",""+fist+"  "+last+" "+recyclerView.getChildCount()+"  "+mAdapter.getItemCount());
              if(!isFirt&&fist == 0){
                  isGetMore = false;
                  isFresh = true;
                  if(!mRefresh.isRefreshing()&&!isFirt){
                      mRefresh.setEnabled(true);
                      mRefresh.setRefreshing(true);
                      Log.d("aaaa","fffffffffsssss");
                      isFirt = false;
                  }
              }else  if(last+1 == mAdapter.getItemCount()) {
                  isGetMore = true;
                  isFresh = false;
                  Log.d("fff", "" + mRefresh.isRefreshing() + "   " + isFirt);
                  if (!mRefresh.isRefreshing() && !isFirt) {
                      mRefresh.setEnabled(true);
                      mRefresh.setRefreshing(true);
                      Log.d("aaaa", "ffffffffflllll");
                      isFirt = false;
                  }
              }else {
                  mRefresh.setEnabled(false);
                  mRefresh.setRefreshing(false);
              }

          }
      });

      reqestData();
        return view;
    }

    private void reqestData(){
        HttpUtils.Request(Constants.Joking,callback);
    }


    private HttpUtils.CallBackLinstener callback = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {
            try {
                Gson gson = new Gson();
                JokingModle modle = gson.fromJson(response.body().string(),JokingModle.class);
                mRefresh.setRefreshing(false);

                JokingData data = modle.getData();
                List<JokingData.JokingDatadata> groups = data.getData();
                isHasMore = data.isHas_more();
                if(isFresh){
                    mData.clear();
                    mData.addAll(groups);
                }else if(isGetMore){
                    mData.addAll(groups);
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRefresh.setEnabled(false);
                        mRefresh.setRefreshing(false);
                        mAdapter.notifyDataSetChanged();
                        isFirt = false;
                    }
                });


            }catch (IOException e){
                e.printStackTrace();
            }

        }
    };

}
