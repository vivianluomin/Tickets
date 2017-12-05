package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MoviePopularComments_Author {

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("name")
    private String mName;


    @SerializedName("id")
    private int id;

    public String getmAvatar() {
        return mAvatar;
    }

    public String getmName() {
        return mName;
    }

    public int getId() {
        return id;
    }
}
