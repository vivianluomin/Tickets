package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/7.
 */

public class Movie_CommentsAc {

    @SerializedName("reviews")
    private List<Movie_popularComments> mComments;

    public List<Movie_popularComments> getmComments() {
        return mComments;
    }
}
