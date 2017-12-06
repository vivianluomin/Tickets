package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus1 on 2017/12/6.
 */

public class View_ShortComments extends RelativeLayout {

    private Context mContext;
    private CircleImageView mUserIcom;
    private TextView mUserName;
    private TextView mComments;
    private TextView mPubTiem;


    public View_ShortComments(Context context) {
        this(context,null);
    }

    public View_ShortComments(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_ShortComments(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void  init(){

        View view = View.inflate(mContext, R.layout.view_shortcomments,this);
        mUserIcom = (CircleImageView)view.findViewById(R.id.iv_usericom);
        mUserName = (TextView)view.findViewById(R.id.tv_username);
        mComments = (TextView)view.findViewById(R.id.tv_shortcomments);
        mPubTiem = (TextView)view.findViewById(R.id.tv_pubTime);

    }

    public void setData(Movie_popularComments comments){
        Glide.with(mContext)
                .load(comments.getmAuthor().getmAvatar())
                .asBitmap()
                .placeholder(R.mipmap.ic_usericon)
                .error(R.mipmap.ic_usericon)
                .into(mUserIcom);

       // Log.d("avatar",comments.getmAuthor().getmAvatar());

        mUserName.setText(comments.getmAuthor().getmName());
        mComments.setText(comments.getmContent());
        mPubTiem.setText(comments.getmCreatedTime());

    }
}
