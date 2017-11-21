package com.example.asus1.trainticket.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/11/21.
 */

public class ViewPagerFragment extends Fragment {

    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_viewpageritem,container,false);
        mImageView = (ImageView)view.findViewById(R.id.iv_image_item);

        return view;
    }

    public  void setData(String url){
        Glide.with(getContext())
                .load(url)
                .into(mImageView);
    }
}
