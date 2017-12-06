package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.MovieCommentsHolder;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.Views.View_MovieComments;

import java.util.List;

/**
 * Created by asus1 on 2017/12/6.
 */

public class MovieCommentsApdater extends RecyclerView.Adapter {

    private Context mComtext;
    private List<Movie_popularComments> mComments;

    public MovieCommentsApdater(Context context,List<Movie_popularComments> comments) {

        mComtext = context;
        mComments = comments;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieCommentsHolder(new View_MovieComments(mComtext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MovieCommentsHolder)holder).setData(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }
}
