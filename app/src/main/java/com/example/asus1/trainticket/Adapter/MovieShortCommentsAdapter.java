package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.MovieShortCommentsHolder;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.Views.View_ShortComments;

import java.util.List;

/**
 * Created by asus1 on 2017/12/6.
 */

public class MovieShortCommentsAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<Movie_popularComments> mComments;

    public MovieShortCommentsAdapter(Context context , List<Movie_popularComments> comments) {

        mComments = comments;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieShortCommentsHolder(new View_ShortComments(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MovieShortCommentsHolder)holder).setData(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }
}
