package com.example.asus1.trainticket.Moduls;

import android.view.LayoutInflater;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/5.
 */

public class Movie_DatilsModul {

    @SerializedName("rating")
    private Movie_Rating mRating;

    @SerializedName("original_title")
    private String mOriginal_Name ;

    @SerializedName("blooper_urls")
    private String[] mBlooper_urls;

    @SerializedName("images")
    private Movie_Images mImages;

    @SerializedName("popular_comments")
    private List<Movie_popularComments> mPopularComments;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("schedule_url")
    private String mScheduleUrl;

    @SerializedName("writers")
    private List<MovieWriters_Modul> mWriters;

    @SerializedName("pubdate")
    private String mPublicDate;

    @SerializedName("genres")
    private String[] mTags;

    @SerializedName("year")
    private String mYear;

    @SerializedName("durations")
    private String[] mDurations;

    @SerializedName("trailers")
    private List<Movie_Trailers> mTrailers;

    @SerializedName("bloopers")
    private List<Movie_bloopers> mBloopers;

    @SerializedName("casts")
    private List<MovieWriters_Modul> mActors;

    @SerializedName("countries")
    private String[] mCountries;

    @SerializedName("mainland_pubdate")
    private String mMainLand_pubdate;

    @SerializedName("photos")
    private List<Movie_photo> mPhotos;

    @SerializedName("summary")
    private String mSummary;

    @SerializedName("directors")
    private List<MovieWriters_Modul> mDirectors;

    @SerializedName("popular_reviews")
    private List<Movie_popularComments> mPopular_reviews;


    public Movie_Rating getmRating() {
        return mRating;
    }

    public String getmOriginal_Name() {
        return mOriginal_Name;
    }

    public String[] getmBlooper_urls() {
        return mBlooper_urls;
    }

    public Movie_Images getmImages() {
        return mImages;
    }

    public List<Movie_popularComments> getmPopularComments() {
        return mPopularComments;
    }

    public int getId() {
        return id;
    }

    public String getmYear() {
        return mYear;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmScheduleUrl() {
        return mScheduleUrl;
    }

    public List<MovieWriters_Modul> getmWriters() {
        return mWriters;
    }

    public String getmPublicDate() {
        return mPublicDate;
    }

    public String[] getmTags() {
        return mTags;
    }

    public String[] getmDurations() {
        return mDurations;
    }

    public List<Movie_Trailers> getmTrailers() {
        return mTrailers;
    }

    public List<Movie_bloopers> getmBloopers() {
        return mBloopers;
    }

    public List<MovieWriters_Modul> getmActors() {
        return mActors;
    }

    public String[] getmCountries() {
        return mCountries;
    }

    public String getmMainLand_pubdate() {
        return mMainLand_pubdate;
    }

    public List<Movie_photo> getmPhotos() {
        return mPhotos;
    }

    public String getmSummary() {
        return mSummary;
    }

    public List<MovieWriters_Modul> getmDirectors() {
        return mDirectors;
    }

    public List<Movie_popularComments> getmPopular_reviews() {
        return mPopular_reviews;
    }
}
