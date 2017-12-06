package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/12/6.
 */

public class View_MovieComments extends RelativeLayout {

    private Context mContext;
    private TextView mTitle;
    private TextView mUsername;
    private TextView mComments;


    public View_MovieComments(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void  init(){
        View view = View.inflate(mContext, R.layout.view_moviecomments,this);
        mTitle = (TextView)view.findViewById(R.id.tv_commentsTitle);
        mUsername = (TextView)view.findViewById(R.id.tv_commentsauthor);
        mComments = (TextView)view.findViewById(R.id.tv_comments);


    }

    public void setData(Movie_popularComments comments){
        mTitle.setText(comments.getmTitle());
        mUsername.setText("作者："+comments.getmAuthor().getmName());
        mComments.setText(comments.getmSummary());

    }
}
