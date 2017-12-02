package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.TrainlList_modul;
import com.example.asus1.trainticket.Views.View_train_item;

/**
 * Created by asus1 on 2017/11/30.
 */

public class TrainItemHolder extends RecyclerView.ViewHolder {
    private View_train_item mViews;

    public TrainItemHolder(View itemView) {
        super(itemView);
        mViews = (View_train_item) itemView;

    }

    public void setData(TrainlList_modul modul){
        mViews.setData(modul);

    }
}
