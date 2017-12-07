package com.example.asus1.trainticket.Moduls;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus1 on 2017/12/7.
 */

public class JokeGroup {


    @SerializedName("user")
    private User mUser;

    @SerializedName("content")
    private String mContent;

    @SerializedName("category_name")
    private String mCategory_name;

    public User getmUser() {
        return mUser;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmCategory_name() {
        return mCategory_name;
    }

   public class User{

        @SerializedName("name")
        private String mName;

        @SerializedName("avatar_url")
        private String mAvatar;

        public String getmName() {
            return mName;
        }

        public String getmAvatar() {
            return mAvatar;
        }
    }

}
