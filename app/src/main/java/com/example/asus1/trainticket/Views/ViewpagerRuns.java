package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.asus1.trainticket.Adapter.ViewPagerAdapter;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Fragments.ViewPagerFragment;
import com.example.asus1.trainticket.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2017/11/21.
 */

public class ViewpagerRuns extends RelativeLayout implements ViewPager.OnPageChangeListener{

    private Context mContext;
    private LinearLayout mPonitLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private View mDian1;
    private View mDian2;
    private View mDian3;
    private View mDian4;
    private List<Fragment> mFragments;
    private List<View> mDians;
    private FragmentManager mFm;

    public ViewpagerRuns(Context context,FragmentManager fm) {
        super(context);
        mContext = context;
        mFm = fm;
        init();
    }

    private void  init(){
        View view = View.inflate(mContext, R.layout.view_viewpagerruns,this);
        mPonitLayout = (LinearLayout)view.findViewById(R.id.ll_pointgroup);
        mViewPager = (ViewPager)view.findViewById(R.id.vp_viewpager);
        mDian1 = new ImageView(mContext);
        mDian1.setBackgroundResource(R.mipmap.ic_dian_whiet);
        mDian2 = new ImageView(mContext);
        mDian2.setBackgroundResource(R.mipmap.ic_dian_gray);
        mDian3 = new ImageView(mContext);
        mDian3.setBackgroundResource(R.mipmap.ic_dian_gray);
        mDian4 = new ImageView(mContext);
        mDian4.setBackgroundResource(R.mipmap.ic_dian_gray);


        mDians = new ArrayList<>();
        mDians.add(mDian1);
        mDians.add(mDian2);
        mDians.add(mDian3);
        mDians.add(mDian4);
        mPonitLayout.addView(mDian1);
        mPonitLayout.addView(mDian2);
        mPonitLayout.addView(mDian3);
        mPonitLayout.addView(mDian4);
        mFragments = new ArrayList<>();
        for(int i = 0;i<4;i++){
            mFragments.add(new ViewPagerFragment());
        }
        mAdapter = new ViewPagerAdapter(mFm,mFragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {
      for(int i =0;i<mDians.size();i++){
          if(i!=position){
              mDians.get(i).setBackgroundResource(R.mipmap.ic_dian_gray);
          }else {
              mDians.get(i).setBackgroundResource(R.mipmap.ic_dian_whiet);
          }
      }
    }


}
