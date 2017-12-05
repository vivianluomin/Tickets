package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.Movie_casts;
import com.example.asus1.trainticket.R;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by asus1 on 2017/12/5.
 */

public class View_MoviePhoto extends RelativeLayout {

    private Context mContext;
    private ImageView mImage;
    private VideoView mVideo;
    private MediaController mController;

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

            }
        });

        mVideo = (VideoView)view.findViewById(R.id.video);
        mController = new MediaController(mContext);
        mVideo.setMediaController(mController);
    }

    public void setData(String url,int tag){
        if(tag == 0){
            Glide.with(mContext)
                    .load(url)
                    .placeholder(R.mipmap.bg_failed)
                    .error(R.mipmap.bg_failed)
                    .into(mImage);
        }else {
            mVideo.setVideoURI(Uri.parse(url));
            mVideo.setVisibility(VISIBLE);
            mImage.setVisibility(GONE);
        }



    }
}
