package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by asus1 on 2017/12/7.
 */

public class JokingData {

    @SerializedName("has_more")
    private boolean has_more;

    @SerializedName("data")
    private List<JokingDatadata> data;

    public boolean isHas_more() {
        return has_more;
    }

    public List<JokingDatadata> getData() {
        return data;
    }


    public class JokingDatadata{
        @SerializedName("group")
        private JokeGroup group;

        public JokeGroup getGroup() {
            return group;
        }
    }
}
