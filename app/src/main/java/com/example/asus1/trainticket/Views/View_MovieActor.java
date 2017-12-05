package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.MovieWriters_Modul;
import com.example.asus1.trainticket.R;

import java.util.List;

/**
 * Created by asus1 on 2017/12/5.
 */

public class View_MovieActor extends RelativeLayout {

    private Context mContext;
    private ImageView mImage;
    private TextView mName;
    private  TextView mDirector;

    public View_MovieActor(Context context) {
        this(context,null);
    }

    public View_MovieActor(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_MovieActor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        View view = View.inflate(mContext, R.layout.view_movieactors,this);
        mImage = (ImageView)view.findViewById(R.id.iv_photo);
        mName = (TextView)view.findViewById(R.id.tv_name);
        mDirector = (TextView)view.findViewById(R.id.tv_director);

    }

    public void setData(MovieWriters_Modul modul,int tag){
        Glide.with(mContext)
                .load(modul.getmAvatars().getmSmall())
                .placeholder(R.mipmap.bg_failed)
                .error(R.mipmap.bg_failed)
                .into(mImage);
        mName.setText(modul.getmName());
        if(tag == 1){
            mDirector.setVisibility(VISIBLE);

        }

    }

}
