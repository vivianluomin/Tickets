package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.Movie_casts;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.activities.PlayVideoActivity;

import java.util.HashMap;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by asus1 on 2017/12/5.
 */

public class View_MoviePhoto extends RelativeLayout {

    private Context mContext;
    private ImageView mImage;
    private ImageView mPlayVideo;
    private String mRerouce;
    private int mTag;


    public View_MoviePhoto(Context context) {
        this(context,null);
    }

    public View_MoviePhoto(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_MoviePhoto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void  init(){
        View view = View.inflate(mContext, R.layout.view_movie_photo,this);
        mImage = (ImageView)view.findViewById(R.id.iv_movie_photo);
        mImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, PlayVideoActivity.class);
                intent.putExtra("url",mRerouce);
                intent.putExtra("tag",mTag);
                mContext.startActivity(intent);

            }
        });
        mPlayVideo = (ImageView)findViewById(R.id.iv_playvideo);






    }

    public void setData(String url,String resource,int tag){
        mRerouce = resource;
        mTag = tag;
        Glide.with(mContext)
            .load(url)
            .placeholder(R.mipmap.bg_failed)
            .error(R.mipmap.bg_failed)
            .into(mImage);
        if(tag == 1){
            mPlayVideo.setVisibility(VISIBLE);
        }else {
            mPlayVideo.setVisibility(GONE);
            mRerouce = url;
        }


    }


}
