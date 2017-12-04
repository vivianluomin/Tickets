package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Views.Loadind_Dialog;

public class Movie_Details_Activity extends BaseActivity {

    private String mUrl = "";
    private Loadind_Dialog mLoding;
    private ImageView mBack;
    private ImageView mCover;
    private TextView mMovieTitle;
    private TextView mMovieType;
    private TextView mOriginName;
    private TextView mShowTime;
    private TextView mRatingText;
    private RatingBar mRating;
    private TextView mSummary;
    private RecyclerView mRecyclerPhoto;
    private RecyclerView mRecyclerActor;
    private RecyclerView mShortComment;
    private RecyclerView mMovieComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__details_);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
    }
}
