package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/28.
 */

public class Train_modul {

    @SerializedName("code")
    private int mCode;

    @SerializedName("data")
    private TrainData_modul mData;

    public int getmCode() {
        return mCode;
    }

    public TrainData_modul getmData() {
        return mData;
    }
}
