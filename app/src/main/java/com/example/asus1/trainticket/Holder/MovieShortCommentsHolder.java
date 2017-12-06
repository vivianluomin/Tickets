package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.Views.View_ShortComments;

/**
 * Created by asus1 on 2017/12/6.
 */

public class MovieShortCommentsHolder extends RecyclerView.ViewHolder {

    private View_ShortComments view;

    public MovieShortCommentsHolder(View itemView) {
        super(itemView);
        view = (View_ShortComments)itemView;
    }

    public void setData(Movie_popularComments comments){
        view.setData(comments);
    }
}
