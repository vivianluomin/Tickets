package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus1.trainticket.Adapter.MovieShortCommentsAdapter;
import com.example.asus1.trainticket.ContentUtill.Constants;
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

public class ShortCommentActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    private MovieShortCommentsAdapter mAapter;
    private List<Movie_popularComments> mComments= new ArrayList<>();
    private TextView mTitle;
    private ImageView mBack;
    private int mId;
    private String title;
    private Loadind_Dialog mLoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_comment);

        Intent intent = getIntent();
        mId = intent.getIntExtra("id",-1);
        title = intent.getStringExtra("title");
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
        mAapter = new MovieShortCommentsAdapter(this,mComments);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mAapter);
        mLoding = new Loadind_Dialog(this);
        RequestData();
    }

    private void RequestData(){

        if(mId!=-1){
            mLoding.show();
            String url = Constants.Movie_ShortComments+mId+Constants.Movie_ShortComments_params;
            HttpUtils.Request(url,callback);
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
                Movie_ShortCommentsAc module = gson.fromJson(response.body().string(),Movie_ShortCommentsAc.class);
                mComments.clear();
                mComments.addAll(module.getmComments());
                mLoding.dismiss();
                ShortCommentActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAapter.notifyDataSetChanged();
                    }
                });
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    };
}
