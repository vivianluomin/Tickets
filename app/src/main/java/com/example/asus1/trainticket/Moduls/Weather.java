package com.example.asus1.trainticket.Moduls;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2017/11/24.
 */

public class Weather {

    @SerializedName("HeWeather6")
    private JsonElement[] HeWeather6;

    public JsonElement[] getHeWeather6() {
        return HeWeather6;
    }
}

