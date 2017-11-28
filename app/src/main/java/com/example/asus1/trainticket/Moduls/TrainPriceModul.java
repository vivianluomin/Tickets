package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/28.
 */

public class TrainPriceModul {


    @SerializedName("leftNumber")
    private int mLeftNum;

    @SerializedName("seatStatus")
    private String mSeatStatus;

    @SerializedName("price")
    private float mPrice;

    @SerializedName("seatName")
    private String mSeatName;

    public int getmLeftNum() {
        return mLeftNum;
    }

    public String getmSeatStatus() {
        return mSeatStatus;
    }

    public float getmPrice() {
        return mPrice;
    }

    public String getmSeatName() {
        return mSeatName;
    }
}
