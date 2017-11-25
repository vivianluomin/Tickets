package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/11/25.
 */

public class Weather6 {



        @SerializedName("basic")
        private Weather_basic basic;

        @SerializedName("now")
        private Weaher_now air_now_city;

        public Weather_basic getBasic() {
            return basic;
        }

        public Weaher_now getAir_now_city() {
            return air_now_city;
        }

}
