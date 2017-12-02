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
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.Train_modul;
import com.example.asus1.trainticket.Moduls.TrainlList_modul;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.FileUtil;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.Calendar_Dialog;
import com.example.asus1.trainticket.Views.Loadind_Dialog;
import com.example.asus1.trainticket.Views.RecyclerViewDecoration;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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
    private Loadind_Dialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_station);

        Intent intent = getIntent();
        mTrainUrl = intent.getStringExtra("url");
        mStartStation = intent.getStringExtra("startStation");
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

        loading = new Loadind_Dialog(this);
        loading.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_huanzhuan:
                String station = String.valueOf(mStatStationText.getText());
                mStatStationText.setText(mEndStaionText.getText());
                mEndStaionText.setText(station);
                setUrl(String.valueOf(mTimeText.getText()));
                break;
            case R.id.iv_calendar:

                final Calendar_Dialog dialog = new Calendar_Dialog(TrainStationActivity.this);
                dialog.setCalendarListener(new Calendar_Dialog.CalenderLinseter() {
                    @Override
                    public void getSelectedData(String date) {
                        mTimeText.setText(date);
                        dialog.dismiss();
                        setUrl(String.valueOf(mTimeText.getText()));

                    }
                });
                dialog.show();

                break;
            case R.id.tv_before:
                String timebefore = String.valueOf(mTimeText.getText());
                Calendar calendar1 = new GregorianCalendar();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
                try {
                    Date date = format1.parse(timebefore);
                    // Log.d("time",date.getTime());
                    calendar1.setTime(date);
                    calendar1.add(Calendar.DAY_OF_MONTH,-1);
                    String t = format1.format(calendar1.getTime());
                    mTimeText.setText(t);
                    Log.d("tIME",t);
                    setUrl(t);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                break;
            case R.id.tv_afterday:
                String time = String.valueOf(mTimeText.getText());
                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
                try {
                    Date date = format.parse(time);
                    // Log.d("time",date.getTime());
                    calendar.setTime(date);
                    calendar.add(Calendar.DAY_OF_MONTH,1);
                    String t = format.format(calendar.getTime());
                    mTimeText.setText(t);
                    Log.d("tIME",t);
                setUrl(t);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                break;
        }

    }

    private void setUrl(String t){

            String[] codes = FileUtil.getCodes(TrainStationActivity.this
                    ,String.valueOf(mStatStationText.getText()),String.valueOf(mEndStaionText.getText()));
            mTrainUrl  = Constants.TRAIN_URL
                    +Constants.Train_Time+t
                    +Constants.Train_StartCityCode+codes[0]
                    +Constants.Train_StartCityName+String.valueOf(mStatStationText.getText())
                    +Constants.Train_EndCityCode+codes[1]
                    +Constants.Train_EdnCityNmae+String.valueOf(mEndStaionText.getText())
                    +Constants.Train_endParam;
            requestData();



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
                loading.dismiss();
                mAdapter.notifyDataSetChanged();

            }
        });

    }
}
