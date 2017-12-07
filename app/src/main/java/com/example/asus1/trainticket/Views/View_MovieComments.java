package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.activities.ShowMovieCommentsActivity;

/**
 * Created by asus1 on 2017/12/6.
 */

public class View_MovieComments extends RelativeLayout implements View.OnClickListener{

    private Context mContext;
    private TextView mTitle;
    private TextView mUsername;
    private TextView mComments;

    private Movie_popularComments mMovie_popularComments;


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
        this.setOnClickListener(this);



    }

    public void setData(Movie_popularComments comments){
        mTitle.setText(comments.getmTitle());
        mUsername.setText("作者："+comments.getmAuthor().getmName());
        mComments.setText(comments.getmSummary());
        mMovie_popularComments = comments;

    }

    @Override
    public void onClick(View v) {
        if(mMovie_popularComments!=null){
            int id = mMovie_popularComments.getId();
            Log.d("id",String.valueOf(id));
            if(id !=0){
                String url = Constants.Movie_Reviews+id;
                Intent intent = new Intent(mContext, ShowMovieCommentsActivity.class);
                intent.putExtra("url",url);
                mContext.startActivity(intent);
            }
        }
    }
}
