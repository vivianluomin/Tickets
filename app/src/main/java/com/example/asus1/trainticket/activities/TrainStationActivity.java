package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus1.trainticket.R;

public class TrainStationActivity extends BaseActivity {

    private String mTrainUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_station);

        Intent intent = getIntent();
        mTrainUrl = intent.getStringExtra("url");

        init();
    }

    private void init(){

    }
}
