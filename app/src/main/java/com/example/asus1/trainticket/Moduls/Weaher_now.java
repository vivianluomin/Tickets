package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/24.
 */

public class Weaher_now {

    @SerializedName("cond_code")
    private String mWeather_icon;

    @SerializedName("cond_txt")
    private String mWeather_data;

    @SerializedName("tmp")
    private String mTmp;

    @SerializedName("wind_sc")
    private String mWind;

    public String getmWeather_icon() {
        return mWeather_icon;
    }

    public void setmWeather_icon(String mWeather_icon) {
        this.mWeather_icon = mWeather_icon;
    }

    public String getmWeather_data() {
        return mWeather_data;
    }

    public void setmWeather_data(String mWeather_data) {
        this.mWeather_data = mWeather_data;
    }

    public String getmTmp() {
        return mTmp;
    }

    public void setmTmp(String mTmp) {
        this.mTmp = mTmp;
    }

    public String getmWind() {
        return mWind;
    }

    public void setmWind(String mWind) {
        this.mWind = mWind;
    }
}
