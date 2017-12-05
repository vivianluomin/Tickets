package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/5.
 */

public class MovieWriters_Modul {

    @SerializedName("avatars")
    private MovieDatil_WritersAvatars mAvatars;

    @SerializedName("name_en")
   private  String mName_en;

    @SerializedName("name")
    private String mName;

    @SerializedName("id")
    private int id;

    public MovieDatil_WritersAvatars getmAvatars() {
        return mAvatars;
    }

    public String getmName_en() {
        return mName_en;
    }

    public String getmName() {
        return mName;
    }

    public int getId() {
        return id;
    }
}
