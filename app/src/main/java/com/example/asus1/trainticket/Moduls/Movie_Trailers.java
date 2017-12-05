package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/5.
 */

public class Movie_Trailers {

    @SerializedName("medium")
    private String mMeddiumImage;

    @SerializedName("title")
   private String mTitle;

    @SerializedName("small")
    private String mSmallImage;

    @SerializedName("resource_url")
    private String mResourceUrl;

    @SerializedName("id")
    private int id;

    public String getmMeddiumImage() {
        return mMeddiumImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSmallImage() {
        return mSmallImage;
    }

    public String getmResourceUrl() {
        return mResourceUrl;
    }

    public int getId() {
        return id;
    }
}
