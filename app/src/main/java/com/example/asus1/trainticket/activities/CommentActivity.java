package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.trainticket.Adapter.MovieCommentsApdater;
import com.example.asus1.trainticket.Adapter.MovieShortCommentsAdapter;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.Movie_CommentsAc;
import com.example.asus1.trainticket.Moduls.Movie_ShortCommentsAc;
import com.example.asus1.trainticket.Moduls.Movie_popularComments;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.Loadind_Dialog;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class CommentActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    private MovieShortCommentsAdapter mAapter;
    private MovieCommentsApdater mAdaptetReview;
    private List<Movie_popularComments> mComments= new ArrayList<>();
    private TextView mTitle;
    private ImageView mBack;
    private int mId;
    private String title;
    private Loadind_Dialog mLoding;
    private int mTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_comment);

        Intent intent = getIntent();
        mId = intent.getIntExtra("id",-1);
        title = intent.getStringExtra("title");
        mTag = intent.getIntExtra("tag",-1);
        init();

    }

    private void  init(){
        mBack = (ImageView)findViewById(R.id.iv_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTitle = (TextView)findViewById(R.id.tv_title);
        mTitle.setText(title);
        mRecyclerview = (RecyclerView)findViewById(R.id.rv_recyclerview);
        if(mTag == 0){
            mAapter = new MovieShortCommentsAdapter(this,mComments);
        }else if(mTag == 1){
            mAdaptetReview = new MovieCommentsApdater(this,mComments);
        }
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        if(mAapter !=null){
            mRecyclerview.setAdapter(mAapter);
        }

        if(mAdaptetReview!=null){
            mRecyclerview.setAdapter(mAdaptetReview);
        }
        mLoding = new Loadind_Dialog(this);
        RequestData();
    }

    private void RequestData(){

        if(mId!=-1){
            mLoding.show();
            String url="";
            if(mTag == 0){
                 url = Constants.Movie_ShortComments+mId+Constants.Movie_ShortComments_params;
            }else  if(mTag == 1){
                url = Constants.Movie_Comments+mId+Constants.Movie_Comments_Param;
            }
            if(!url.equals("")){
                HttpUtils.Request(url,callback);
            }

        }

    }

    private HttpUtils.CallBackLinstener callback = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {
            try {
                Gson gson = new Gson();
                if(mTag == 0){
                    Movie_ShortCommentsAc module = gson.fromJson(response.body().string(),Movie_ShortCommentsAc.class);
                    mComments.clear();
                    mComments.addAll(module.getmComments());
                    CommentActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAapter.notifyDataSetChanged();
                        }
                    });
                }else if(mTag == 1){

                    Movie_CommentsAc module = gson.fromJson(response.body().string(),Movie_CommentsAc.class);
                    mComments.clear();
                    mComments.addAll(module.getmComments());
                    CommentActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdaptetReview.notifyDataSetChanged();
                        }
                    });

                }


                mLoding.dismiss();

            }catch (IOException e){
                e.printStackTrace();
            }

        }
    };
}
