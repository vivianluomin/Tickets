package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.MovieActorHolder;
import com.example.asus1.trainticket.Moduls.MovieWriters_Modul;
import com.example.asus1.trainticket.Views.View_MovieActor;

import java.util.List;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MovieActosAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<MovieWriters_Modul> mDirectors;
    private List<MovieWriters_Modul> mActors;

    public MovieActosAdapter(Context context, List<MovieWriters_Modul> directors,List<MovieWriters_Modul> actors) {
        mContext = context;
        mDirectors = directors;
        mActors = actors;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View_MovieActor view = new View_MovieActor(mContext);
        MovieActorHolder holder = new MovieActorHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MovieActorHolder holder1 = (MovieActorHolder) holder;

        if(position<mDirectors.size()){
           holder1.setData(mDirectors.get(position),1);
        }else {
            holder1.setData(mActors.get(position-mDirectors.size()),0);
        }

    }

    @Override
    public int getItemCount() {
        return mDirectors.size()+mActors.size();
    }


}
