package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/3.
 */

public class Movie_photo{
    @SerializedName("image")
    private String mImage;

    @SerializedName("cover")
    private String mCover;

    public String getmImage() {
        return mImage;
    }

    public String getmCover() {
        return mCover;
    }
}