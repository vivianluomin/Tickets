package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.Movie_casts;
import com.example.asus1.trainticket.Moduls.Movie_director;
import com.example.asus1.trainticket.Moduls.Movie_subject;
import com.example.asus1.trainticket.R;

import java.util.List;

/**
 * Created by asus1 on 2017/12/2.
 */

public class View_Movie_item extends RelativeLayout {

    private Context mContext;
    private ImageView mMovieImage;
    private TextView mTitle;
    private TextView mDration;
    private RatingBar mRating;
    private TextView mDirectors;
    private TextView mActors;

    public View_Movie_item(Context context) {
        this(context,null);
    }

    public View_Movie_item(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_Movie_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        View view = inflate(mContext, R.layout.view_movie_item,this);
        mMovieImage = (ImageView)view.findViewById(R.id.iv_movie_image);
        mTitle = (TextView)view.findViewById(R.id.tv_movie_title);
        mDration = (TextView)view.findViewById(R.id.tv_duration);
        mRating = (RatingBar)view.findViewById(R.id.rb_rating);
        mDirectors = (TextView)view.findViewById(R.id.tv_directors);
        mActors = (TextView)view.findViewById(R.id.tv_actors);

    }

    public void setData(Movie_subject subject){
        mRating.setRating(subject.getmRatings().getmAverage());
        mTitle.setText(subject.getmTitle());
        mDration.setText(subject.getmDuration()[0]);
        Glide.with(mContext)
                .load(subject.getmImages().getmSmall())
                .placeholder(R.mipmap.bg_failed)
                .error(R.mipmap.bg_failed)
                .into(mMovieImage);
        String di = "";
        String ac = "";
        List<Movie_casts> casts = subject.getmCasts();
        for(int i =0;i<casts.size();i++){
            ac+=casts.get(i).getnName_C();
            ac+="  ";
        }


        List<Movie_director> directors = subject.getmDirectors();

        for(int i =0;i<directors.size();i++){
            di+=directors.get(i).getmName_C();
            di+="  ";

        }

        mDirectors.setText("导演："+di);
        mActors.setText("演员:"+ac);

    }
}
