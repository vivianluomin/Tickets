package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.AppBarLayout;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Adapter.MovieActosAdapter;
import com.example.asus1.trainticket.Adapter.MovieCommentsApdater;
import com.example.asus1.trainticket.Adapter.MoviePhotosAdapter;
import com.example.asus1.trainticket.Adapter.MovieShortCommentsAdapter;
import com.example.asus1.trainticket.Moduls.MovieWriters_Modul;
import com.example.asus1.trainticket.Moduls.Movie_DatilsModul;
import com.example.asus1.trainticket.Moduls.Movie_bloopers;
import com.example.asus1.trainticket.Moduls.Movie_photo;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.Loadind_Dialog;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class Movie_Details_Activity extends BaseActivity {

    private String mUrl = "";
    private Loadind_Dialog mLoding;
    private ImageView mBack;
    private ImageView mCover;
    private TextView mMovieTitle;
    private TextView mMovieType;
    private TextView mOriginName;
    private TextView mShowTime;
    private TextView mDuration;
    private TextView mRatingText;
    private RatingBar mRating;
    private TextView mSummary;
    private AppBarLayout mActionBar;
    private RecyclerView mRecyclerPhoto;
    private RecyclerView mRecyclerActor;
    private RecyclerView mShortComment;
    private RecyclerView mMovieComment;
    private TextView mSeeAllShort;
    private TextView mSeeAllComm;

    private int mId;


    private MovieActosAdapter mActorAdapter;
    private MoviePhotosAdapter mPhotoAdapter;
    private MovieShortCommentsAdapter mShortCommentsAdapter;
    private MovieCommentsApdater mMoiveCommentsAdapter;


    private List<MovieWriters_Modul> mActors = new ArrayList<>();
    private List<MovieWriters_Modul> mDirectors = new ArrayList<>();
    private List<Movie_bloopers> mMovie_bloopers = new ArrayList<>();
    private List<Movie_photo> mPhotos = new ArrayList<>();
    private List<Movie_popularComments> mShortComments = new ArrayList<>();
    private List<Movie_popularComments> mMovieCommnts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__details_);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");


        init();
    }

    private void  init(){
        mLoding = new Loadind_Dialog(this);

        mActionBar = (AppBarLayout)findViewById(R.id.actionbar);
        mBack = (ImageView)findViewById(R.id.iv_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mCover = (ImageView)findViewById(R.id.iv_cover);
        mMovieTitle = (TextView)findViewById(R.id.tv_movie_title);
        mMovieType = (TextView)findViewById(R.id.tv_type);
        mOriginName = (TextView)findViewById(R.id.tv_orignalname);
        mShowTime = (TextView)findViewById(R.id.tv_onShowTime);
        mDuration = (TextView)findViewById(R.id.tv_duration);
        mRatingText = (TextView)findViewById(R.id.tv_rating);
        mRating = (RatingBar)findViewById(R.id.rb_rating);
        mSummary = (TextView)findViewById(R.id.tv_summary);
        mRecyclerActor = (RecyclerView)findViewById(R.id.rv_recyclerview_actorphoto);
        mRecyclerActor.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mActorAdapter = new MovieActosAdapter(this,mDirectors,mActors);
        mRecyclerActor.setAdapter(mActorAdapter);

        mRecyclerPhoto = (RecyclerView)findViewById(R.id.rv_recyclerview_photo);
        mRecyclerPhoto.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mPhotoAdapter = new MoviePhotosAdapter(this,mPhotos,mMovie_bloopers);
        mRecyclerPhoto.setAdapter(mPhotoAdapter);

        mShortComment = (RecyclerView)findViewById(R.id.rv_recyclerview_shortcomment);
        mShortCommentsAdapter = new MovieShortCommentsAdapter(this,mShortComments);
        mShortComment.setLayoutManager(new LinearLayoutManager(this));
        mShortComment.setAdapter(mShortCommentsAdapter);

        mMovieComment = (RecyclerView)findViewById(R.id.rv_recyclerview_moviecomment);
        mMoiveCommentsAdapter = new MovieCommentsApdater(this,mMovieCommnts);
        mMovieComment.setLayoutManager(new LinearLayoutManager(this));
        mMovieComment.setAdapter(mMoiveCommentsAdapter);

        mSeeAllShort = (TextView)findViewById(R.id.tv_AllShortComments);
        mSeeAllShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie_Details_Activity.this,CommentActivity.class);
                intent.putExtra("id",mId);
                intent.putExtra("title",mMovieTitle.getText());
                intent.putExtra("tag",0);
                startActivity(intent);
            }
        });

        mSeeAllComm = (TextView)findViewById(R.id.tv_AllComments);
        mSeeAllComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie_Details_Activity.this,CommentActivity.class);
                intent.putExtra("id",mId);
                intent.putExtra("title",mMovieTitle.getText());
                intent.putExtra("tag",1);
                startActivity(intent);
            }
        });

        requestData();
    }

    private void requestData(){
        mLoding.show();
        HttpUtils.Request(mUrl,callBack);

    }

    private HttpUtils.CallBackLinstener callBack = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {

            try{

                Gson gson = new Gson();
                String s = response.body().string();
                Movie_DatilsModul modul = gson.fromJson(s,Movie_DatilsModul.class);
                if(modul!=null){
                    mDirectors.clear();
                    mDirectors.addAll(modul.getmDirectors());
                    mActors.clear();
                    mActors.addAll(modul.getmActors());
                    mMovie_bloopers.clear();
                    mMovie_bloopers .addAll(modul.getmBloopers());
                    mPhotos.clear();
                    mPhotos.addAll(modul.getmPhotos());
                    mShortComments.clear();
                    mShortComments.addAll(modul.getmPopularComments());
                    mMovieCommnts.clear();
                    mMovieCommnts.addAll(modul.getmPopular_reviews());

                }
                setData(modul);
                mLoding.dismiss();

            }catch (IOException e){
                e.printStackTrace();

            }

        }
    };

    private void setData(final Movie_DatilsModul modul){
        final  Bitmap  bitmap = getBitmap(modul.getmImages().getmLarge());
        mId = modul.getId();
        Movie_Details_Activity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(bitmap!=null){
                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            Palette.Swatch swatch = palette.getDarkMutedSwatch();
                            if(swatch!=null){
                                mActionBar.setBackgroundColor(swatch.getRgb());
                            }
                        }
                    });
                }

                Glide.with(Movie_Details_Activity.this)
                        .load(modul.getmImages().getmLarge())
                        .placeholder(R.mipmap.bg_failed)
                        .error(R.mipmap.bg_failed)
                        .into(mCover);

                mMovieTitle .setText(modul.getmTitle());
                String tag = modul.getmYear();
                for(int i =0;i<modul.getmTags().length;i++){
                    tag+="/";
                    tag+=modul.getmTags()[i];

                }
                mMovieType.setText(tag);
                mShowTime.setText("上映时间："+modul.getmPublicDate());
                mDuration.setText("片长："+modul.getmDurations()[0]);
                mRatingText.setText(String.valueOf(modul.getmRating().getmAverage()));
                mRating.setRating(modul.getmRating().getmAverage()/2);
                mOriginName.setText(modul.getmOriginal_Name());

                mSummary.setText(modul.getmSummary());

                mActorAdapter.notifyDataSetChanged();
                mPhotoAdapter.notifyDataSetChanged();
                mShortCommentsAdapter.notifyDataSetChanged();
                mMoiveCommentsAdapter.notifyDataSetChanged();

            }
        });

    }

    private Bitmap getBitmap(String url){
        Bitmap bitmap = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(8000);
            if(connection.getResponseCode() == 200){
                BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            }


        }catch (MalformedURLException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }


        return  bitmap;
    }
}
