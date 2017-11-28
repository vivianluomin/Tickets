package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/11/28.
 */

public class TrainlList_modul {

    @SerializedName("trainNum")
    private String mTrainNum;

    @SerializedName("trainTypeName")
    private String mTrainTypeName;

    @SerializedName("departStationName")
    private String mFromStartStation;

    @SerializedName("destStationName")
    private String mFromEndStation;

    @SerializedName("departDepartTime")
    private String mStartTime;

    @SerializedName("destArriveTime")
    private String mEndTime;

    @SerializedName("prices")
    private List<TrainPriceModul> mPrices;

    @SerializedName("departureCityName")
    private String mStartStation;

    @SerializedName("arrivalCityName")
    private String mEndStation;

    @SerializedName("durationStr")
    private int mDuration;

    public String getmTrainNum() {
        return mTrainNum;
    }

    public String getmTrainTypeName() {
        return mTrainTypeName;
    }

    public String getmFromStartStation() {
        return mFromStartStation;
    }

    public String getmFromEndStation() {
        return mFromEndStation;
    }

    public String getmStartTime() {
        return mStartTime;
    }

    public String getmEndTime() {
        return mEndTime;
    }

    public List<TrainPriceModul> getmPrices() {
        return mPrices;
    }

    public String getmStartStation() {
        return mStartStation;
    }

    public String getmEndStation() {
        return mEndStation;
    }

    public int getmDuration() {
        return mDuration;
    }
}
