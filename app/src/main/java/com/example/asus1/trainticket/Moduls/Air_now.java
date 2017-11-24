package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/24.
 */

public class Air_now {

    @SerializedName("aqi")
    private  String mAqi;

    @SerializedName("qlty")
    private String mQlty;

    public String getmAqi() {
        return mAqi;
    }

    public String getmQlty() {
        return mQlty;
    }
}
