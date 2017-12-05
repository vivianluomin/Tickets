package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.MovieWriters_Modul;
import com.example.asus1.trainticket.Views.View_MovieActor;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MovieActorHolder extends RecyclerView.ViewHolder {

    private  View_MovieActor view ;

    public MovieActorHolder(View itemView) {
        super(itemView);
        view = (View_MovieActor)itemView;
    }

    public void setData(MovieWriters_Modul modul,int tag){
        view.setData(modul,tag);
    }
}
