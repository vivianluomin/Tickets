package com.example.asus1.trainticket.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.asus1.trainticket.Adapter.MovieApdater;
import com.example.asus1.trainticket.Adapter.ViewPagerAdapter;
import com.example.asus1.trainticket.Moduls.Movie_subject;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.ViewpagerRuns;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/18.
 */

public class MovieTicketFragment extends Fragment  {

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
        mFm = getFragmentManager();
        mRelative.setLayoutManager(new LinearLayoutManager(getContext()));
        mRelative.setAdapter(mAdapter);
        requestData();

    }

    private void requestData(){

    }


    HttpUtils.CallBackLinstener callBack = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {

        }
    };




}
