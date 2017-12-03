package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/2.
 */

public class Movie_director {

    @SerializedName("name_en")
    private String mName_en;

    @SerializedName("name")
    private String mName_C;

    @SerializedName("alt")
    private String mAlt;

    @SerializedName("id")
    private int id;


    public String getmName_en() {
        return mName_en;
    }

    public String getmName_C() {
        return mName_C;
    }

    public String getmAlt() {
        return mAlt;
    }

    public int getId() {
        return id;
    }
}
