package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Spanned;
import android.util.Log;

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
    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("position",String.valueOf(position));
        return mFragments.get(position);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
    }
}
