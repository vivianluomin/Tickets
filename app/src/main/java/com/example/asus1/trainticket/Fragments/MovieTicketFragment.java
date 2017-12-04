package com.example.asus1.trainticket.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Adapter.MovieApdater;
import com.example.asus1.trainticket.activities.Movie_Details_Activity;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.Movie_subject;
import com.example.asus1.trainticket.Moduls.Moview_Data;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.View_Movie_item;
import com.google.gson.Gson;

import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/18.
 */

public class MovieTicketFragment extends Fragment implements View_Movie_item.RecyclerViewItemListener {

    private RecyclerView mRelative;
    private MovieApdater mAdapter;
    private FragmentManager mFm;
    private List<Movie_subject> mSubjects = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie,container,false);
       init(view);
        return view;
    }

    private void init(View view){
        mRelative = (RecyclerView) view.findViewById(R.id.rv_recyclerview);
        mAdapter = new MovieApdater(getContext(),mSubjects,getChildFragmentManager());
        mAdapter.setLintenser(this);
        mFm = getFragmentManager();
        mRelative.setLayoutManager(new LinearLayoutManager(getContext()));
        mRelative.setAdapter(mAdapter);

        requestData();

    }

    private void requestData(){

        HttpUtils.Request(Constants.Movie_Now,callBack);

    }

    @Override
    public void onItemClick(int position) {
        String url = Constants.Movie_detail+mSubjects.get(position).getId()+Constants.Movie_deatail_Param;
        Log.d("id",String.valueOf(mSubjects.get(position).getId()));
        Intent intent = new Intent(getContext(), Movie_Details_Activity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }

    HttpUtils.CallBackLinstener callBack = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {

            try {
                Gson gson = new Gson();
                Moview_Data data = gson.fromJson(response.body().string(),Moview_Data.class);
                List<Movie_subject> subjects = data.getmSubjects();
                mSubjects.clear();
                mSubjects.addAll(subjects);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                    }
                });

            }catch (IOException e){
                e.printStackTrace();
            }


        }
    };




}
