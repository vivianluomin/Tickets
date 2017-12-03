package com.example.asus1.trainticket.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.ContentUtill.SystemManager;
import com.example.asus1.trainticket.Moduls.Movie_BG_Modul;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/21.
 */

public class ViewPagerFragment extends Fragment {

    private ImageView mImageView;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_viewpageritem,container,false);
        mImageView = (ImageView)view.findViewById(R.id.iv_image_item);

        return view;
    }

    public void setData(int id){

        HttpUtils.Request(Constants.Movie_BG+id+Constants.Movie_BG_Param,callBack);


    }

    HttpUtils.CallBackLinstener callBack = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {

            try {
                Gson gson = new Gson();
                Movie_BG_Modul bg_modul = gson.fromJson(response.body().string(),Movie_BG_Modul.class);
                if(bg_modul!=null){
                    if(bg_modul.getPhotos()!=null&&bg_modul.getPhotos().size()>0){
                        loadImage((bg_modul.getPhotos().get(0)).getmImage());
                    }

                }


            }catch (IOException e){
                e.printStackTrace();
            }


        }
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(mImageView!=null){
                String url = msg.getData().getString("url");
                Glide.with(SystemManager.Context)
                        .load(url)
                        .placeholder(R.mipmap.bg_failed)
                        .error(R.mipmap.bg_failed)
                        .into(mImageView);
            }



        }
    };
    private void loadImage(final  String url){

        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        message.setData(bundle);
        handler.sendMessage(message);

    }
}
