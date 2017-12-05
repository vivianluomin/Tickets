package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/5.
 */

public class Movie_bloopers {

    @SerializedName("medium")
    private String mMedium;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("small")
    private String mSmall;

    @SerializedName("resource_url")
    private String mResource_url;

    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public String getmMedium() {
        return mMedium;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSmall() {
        return mSmall;
    }

    public String getmResource_url() {
        return mResource_url;
    }
}
