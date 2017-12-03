package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/3.
 */

public class Movie_BG_Modul {

    @SerializedName("photos")
    private List<Movie_photo> photos;

    public List<Movie_photo> getPhotos() {
        return photos;
    }


}
