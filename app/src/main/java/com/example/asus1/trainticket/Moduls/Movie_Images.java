package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/3.
 */

public class Movie_Images {

    @SerializedName("small")
    private String mSmall;

    @SerializedName("large")
    private String mLarge;

    public String getmSmall() {
        return mSmall;
    }

    public String getmLarge() {
        return mLarge;
    }
}
