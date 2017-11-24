package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/24.
 */

public class Weather_data {

    @SerializedName("basic")
    private  Weather_basic basic;

    @SerializedName("now")
    private Weaher_now now;


    public Weather_basic getBasic() {
        return basic;
    }

    public Weaher_now getNow() {
        return now;
    }
}
