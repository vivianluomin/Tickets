package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.MoviePhotoHolder;
import com.example.asus1.trainticket.Moduls.Movie_bloopers;
import com.example.asus1.trainticket.Moduls.Movie_photo;
import com.example.asus1.trainticket.Views.View_MoviePhoto;

import java.util.List;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MoviePhotosAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Movie_photo> mPhotos;
    private List<Movie_bloopers> mBloopers;

    public MoviePhotosAdapter(Context context, List<Movie_photo> photos, List<Movie_bloopers> bloopers) {
        this.mContext = context;
        this.mPhotos = photos;
        this.mBloopers = bloopers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviePhotoHolder(new View_MoviePhoto(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MoviePhotoHolder holder1 = (MoviePhotoHolder)holder;

        if(position<mBloopers.size()){
            holder1.setData(mBloopers.get(position).getmResource_url(),1);
        }else{
            holder1.setData(mPhotos.get(position-mBloopers.size()).getmCover(),0);
        }

    }

    @Override
    public int getItemCount() {
        return mBloopers.size()+mPhotos.size();
    }
}
