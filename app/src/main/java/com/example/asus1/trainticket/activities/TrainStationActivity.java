package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus1.trainticket.Adapter.TrainItemAdapter;
import com.example.asus1.trainticket.Moduls.Train_modul;
import com.example.asus1.trainticket.Moduls.TrainlList_modul;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.RecyclerViewDecoration;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class TrainStationActivity extends BaseActivity implements View.OnClickListener{

    private String mTrainUrl;
    private RecyclerView mRecyclerView;
    private TrainItemAdapter mAdapter;
    private List<TrainlList_modul> mLists = new ArrayList<>();
    private String mStartStation;
    private String mEndStation;
    private String mTime;
    private TextView mStatStationText;
    private TextView mEndStaionText;
    private ImageView mBack;
    private ImageView mChangeStation;
    private TextView mBeforeDay;
    private TextView mAfaterDay;
    private TextView mTimeText;
    private ImageView mCanlendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_station);

        Intent intent = getIntent();
        mTrainUrl = intent.getStringExtra("url");
        mStartStation = intent.getStringExtra("statStation");
        mEndStation = intent.getStringExtra("endStation");
        mTime = intent.getStringExtra("time");

        init();
    }

    private void init(){
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_recyclerview);
        mAdapter = new TrainItemAdapter(this,mLists);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerViewDecoration(this));
        mBack = (ImageView)findViewById(R.id.iv_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mStatStationText = (TextView)findViewById(R.id.tv_startStation);
        mStatStationText.setText(mStartStation);
        mEndStaionText = (TextView)findViewById(R.id.tv_endStation);
        mEndStaionText.setText(mEndStation);
        mTimeText= (TextView)findViewById(R.id.tv_time);
        mTimeText.setText(mTime);
        mCanlendar = (ImageView)findViewById(R.id.iv_calendar);
        mCanlendar.setOnClickListener(this);
        mBeforeDay = (TextView) findViewById(R.id.tv_before);
        mBeforeDay.setOnClickListener(this);
        mAfaterDay = (TextView)findViewById(R.id.tv_afterday);
        mAfaterDay.setOnClickListener(this);
        mChangeStation = (ImageView)findViewById(R.id.iv_huanzhuan);
        mChangeStation.setOnClickListener(this);
        requestData();

    }

    private void requestData(){

        HttpUtils.Request(mTrainUrl,callBak);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_huanzhuan:
                break;
            case R.id.calendar:
                break;
            case R.id.tv_before:
                break;
            case R.id.tv_afterday:
                break;
        }

    }

    HttpUtils.CallBackLinstener callBak = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {
            Toast.makeText(TrainStationActivity.this,"无法获取数据",Toast.LENGTH_SHORT);
        }

        @Override
        public void onResponse(Call call, Response response) {
            try{
                Gson gson = new Gson() ;
                Train_modul modul = gson.fromJson(response.body().string(),Train_modul.class);
                if(modul!=null&&modul.getmData().getmLists()!=null&&modul.getmData().getmLists().size()>0){
                    mLists.clear();
                    mLists.addAll(modul.getmData().getmLists());
                    Log.d("aaaa",String.valueOf(mLists.size()));
                    unpdate();
                }


            }catch (IOException e){
                e.printStackTrace();
                Toast.makeText(TrainStationActivity.this,"无法获取数据",Toast.LENGTH_SHORT);
            }

        }
    };

    private void unpdate(){
        TrainStationActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
