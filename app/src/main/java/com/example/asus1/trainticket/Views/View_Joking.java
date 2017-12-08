package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.Moduls.JokeGroup;
import com.example.asus1.trainticket.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by asus1 on 2017/12/7.
 */

public class View_Joking extends RelativeLayout {
    private Context mContext;
    private CircleImageView mUserIcom;
    private TextView mUserName;
    private TextView mComments;
    private TextView mPubTiem;


    public View_Joking(Context context) {
        super(context);
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

    public void setData(JokeGroup data){

        if(data!=null){
            Log.d("avatar",data.getmUser().getmAvatar());
            Glide.with(mContext)
                    .load(data.getmUser().getmAvatar())
                    .asBitmap()
                    .placeholder(R.mipmap.ic_usericon)
                    .error(R.mipmap.ic_usericon)
                    .into(mUserIcom);
            mUserName.setText(data.getmUser().getmName());
            SpannableString string = new SpannableString("#"+data.getmCategory_name()+"#"+data.getmContent());
            string.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_red)),0,data.getmCategory_name().length()+2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mComments.setText(string);
            mPubTiem.setVisibility(GONE);

        }

    }
}
