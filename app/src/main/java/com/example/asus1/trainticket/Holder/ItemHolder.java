package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.Movie_subject;
import com.example.asus1.trainticket.Views.View_Movie_item;

import java.util.List;

/**
 * Created by asus1 on 2017/11/23.
 */

public class ItemHolder extends RecyclerView.ViewHolder {
    private View_Movie_item mView;
    public ItemHolder(View itemView) {

        super(itemView);
        mView = ((View_Movie_item)itemView);
    }

    public void setData(Movie_subject subject){
        mView.setData(subject);
    }
}
