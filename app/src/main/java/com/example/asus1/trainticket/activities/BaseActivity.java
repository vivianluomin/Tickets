package com.example.asus1.trainticket.activities;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.asus1.trainticket.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
           window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


    }
}
