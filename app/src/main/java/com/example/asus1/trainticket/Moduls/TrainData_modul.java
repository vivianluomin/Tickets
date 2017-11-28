package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/11/28.
 */

public class TrainData_modul {

    @SerializedName("list")
    List<TrainlList_modul> mLists;

    public List<TrainlList_modul> getmLists() {
        return mLists;
    }
}
