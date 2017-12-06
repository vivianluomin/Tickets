package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.Views.View_MovieComments;

/**
 * Created by asus1 on 2017/12/6.
 */

public class MovieCommentsHolder extends RecyclerView.ViewHolder {

    private View_MovieComments view;
    public MovieCommentsHolder(View itemView) {
        super(itemView);
        view = (View_MovieComments)itemView;
    }

    public void setData(Movie_popularComments comments){

        view.setData(comments);

    }
}
