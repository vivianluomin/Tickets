package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/5.
 */

public class Movie_popularComments {

    @SerializedName("rating")
    private MovieDatilPopularComments_Rating mRating;

    @SuppressWarnings("author")
    private MoviePopularComments_Author mAuthor;

    @SerializedName("content")
    private String mContent;

    @SerializedName("summary")
    private String mSummary;

    @SerializedName("created_at")
    private String mCreatedTime;

    @SerializedName("id")
    private int id;

    public String getmSummary() {
        return mSummary;
    }

    public MovieDatilPopularComments_Rating getmRating() {
        return mRating;
    }

    public MoviePopularComments_Author getmAuthor() {
        return mAuthor;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmCreatedTime() {
        return mCreatedTime;
    }

    public int getId() {
        return id;
    }
}
