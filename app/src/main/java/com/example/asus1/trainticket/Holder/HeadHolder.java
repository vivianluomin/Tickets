package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;

import com.example.asus1.trainticket.Views.ViewpagerRuns;

/**
 * Created by asus1 on 2017/11/23.
 */

public class HeadHolder extends RecyclerView.ViewHolder {
    private ViewpagerRuns mRuns;

    public HeadHolder(View itemView) {

        super(itemView);
        mRuns = (ViewpagerRuns)itemView;
    }

    public void setData(int[] ids){

        mRuns.setData(ids);
    }
}
