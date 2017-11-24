package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.HeadHolder;
import com.example.asus1.trainticket.Views.ViewpagerRuns;

/**
 * Created by asus1 on 2017/11/23.
 */

public class MovieApdater extends RecyclerView.Adapter {


    private Context mContext;
    private FragmentManager mFm;


    public MovieApdater(Context context, FragmentManager fm) {
        mContext = context;
        mFm = fm;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            return new HeadHolder(new ViewpagerRuns(mContext,mFm));



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
