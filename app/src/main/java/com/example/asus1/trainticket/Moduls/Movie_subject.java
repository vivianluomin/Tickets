package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/2.
 */

public class Movie_subject {

    @SerializedName("rating")
    private List<Movie_Rating> mRatings;

    @SerializedName("genres")
    private String[] mGenres;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("casts")
   private List<Movie_casts> mCasts;

    @SerializedName("duration")
    private int[] mDuration;

    @SerializedName("directors")
    private List<Movie_director> mDirectors;

    @SerializedName("year")
    private int mYear;

    @SerializedName("images")
    private String[] mImages;

    @SerializedName("alt")
    private String mAlt;

    @SerializedName("id")
    private int id;

    public List<Movie_Rating> getmRatings() {
        return mRatings;
    }

    public String[] getmGenres() {
        return mGenres;
    }

    public String getmTitle() {
        return mTitle;
    }

    public List<Movie_casts> getmCasts() {
        return mCasts;
    }

    public int[] getmDuration() {
        return mDuration;
    }

    public List<Movie_director> getmDirectors() {
        return mDirectors;
    }

    public int getmYear() {
        return mYear;
    }

    public String[] getmImages() {
        return mImages;
    }

    public String getmAlt() {
        return mAlt;
    }

    public int getId() {
        return id;
    }
}
