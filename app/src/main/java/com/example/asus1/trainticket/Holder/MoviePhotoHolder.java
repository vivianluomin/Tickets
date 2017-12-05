package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Views.View_MoviePhoto;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MoviePhotoHolder extends RecyclerView.ViewHolder {

    private  View_MoviePhoto view;

    public MoviePhotoHolder(View itemView) {
        super(itemView);
        view = (View_MoviePhoto) itemView;
    }

    public void setData(String url,int tag){
        view.setData(url,tag);
    }
}
