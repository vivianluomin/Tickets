package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Views.Loadind_Dialog;

public class PlayVideoActivity extends BaseActivity {

    private String mUrl;
    private int mTag;
    private VideoView mVideo;
    private ImageView mImage;
    private MediaController mController;
    private Loadind_Dialog mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mTag = intent.getIntExtra("tag",-1);
        init();
    }

    private void  init(){
        mVideo = (VideoView)findViewById(R.id.playvideo);
        mImage = (ImageView)findViewById(R.id.iv_image);
        mController = new MediaController(this);
        mVideo.setMediaController(mController);
        mLoading = new Loadind_Dialog(this);
        mVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    @Override
                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
                        Log.d("perent",String.valueOf(percent));
                        if(percent >= 0){
                            mLoading.dismiss();
                        }
                    }
                });
            }
        });
        setData();
    }

    private void setData(){



        if(mTag == 0){
            mVideo.setVisibility(View.GONE);
            mImage.setVisibility(View.VISIBLE);
            Glide.with(this)
                    .load(mUrl)
                    .placeholder(R.mipmap.bg_failed)
                    .error(R.mipmap.bg_failed)
                    .into(mImage);
        }else if(mTag == 1){
            mLoading.show();

            mVideo.setVisibility(View.VISIBLE);
            mImage.setVisibility(View.GONE);
            mVideo.setVideoPath(mUrl);

            mVideo.start();
        }
    }
}
