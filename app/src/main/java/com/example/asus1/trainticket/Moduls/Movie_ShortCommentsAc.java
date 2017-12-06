package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/6.
 */

public class Movie_ShortCommentsAc {

    @SerializedName("count")
    private int mCounts;

    @SerializedName("comments")
    private List<Movie_popularComments> mComments;

    public int getmCounts() {
        return mCounts;
    }

    public List<Movie_popularComments> getmComments() {
        return mComments;
    }
}
