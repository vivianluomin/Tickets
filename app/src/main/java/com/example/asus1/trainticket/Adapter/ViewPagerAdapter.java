package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Spanned;

import com.example.asus1.trainticket.R;

import java.util.List;

/**
 * Created by asus1 on 2017/11/20.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private  List<Fragment> mFragments;
    private String[] mTitles;
    private Context mContext;
    private int[] mDraws;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;

        mDraws = new int[]{
                R.mipmap.ic_tain_bule1,
                R.mipmap.ic_move1,
                R.mipmap.ic_happy1
        };

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mTitles[position];
    }
}
