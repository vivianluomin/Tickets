package com.example.asus1.trainticket.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/11/18.
 */

public class TrainTicketFragment extends Fragment {

    private ImageView mHeadImage;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_train,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        mHeadImage = (ImageView)view.findViewById(R.id.iv_head_bg);
        Glide.with(getContext())
                .load(Constants.TARIN_BG)
                .placeholder(R.drawable.view_loading)
                .error(R.mipmap.bg_failed)
                .into(mHeadImage);
    }


}
