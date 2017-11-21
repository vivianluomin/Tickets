package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.asus1.trainticket.Adapter.ViewPagerAdapter;
import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/11/21.
 */

public class ViewpagerRuns extends RelativeLayout {

    private Context mContext;
    private LinearLayout mPonitLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    public ViewpagerRuns(Context context) {
       this(context,null);
    }

    public ViewpagerRuns(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ViewpagerRuns(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void  init(){
        View view = View.inflate(mContext, R.layout.view_viewpagerruns,this);
        mPonitLayout = (LinearLayout)view.findViewById(R.id.ll_pointgroup);
        mViewPager = (ViewPager)view.findViewById(R.id.vp_viewpager);

    }
}
