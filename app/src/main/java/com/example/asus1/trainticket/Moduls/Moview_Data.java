package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/2.
 */

public class Moview_Data {

    @SerializedName("count")
    private int mCount;

    @SerializedName("total")
    private int mTotal;

    @SerializedName("subjects")
    private List<Movie_subject> mSubjects;

    public int getmCount() {
        return mCount;
    }

    public int getmTotal() {
        return mTotal;
    }

    public List<Movie_subject> getmSubjects() {
        return mSubjects;
    }
}
