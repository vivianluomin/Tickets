package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/24.
 */

public class Weather_basic {

    @SerializedName("cid")
    private String mId;

    @SerializedName("location")
    private String mLocation;

    public String getmId() {
        return mId;
    }

    public String getmLocation() {
        return mLocation;
    }
}
