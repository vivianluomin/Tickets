package com.example.asus1.trainticket.activities;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.asus1.trainticket.Adapter.ViewPagerAdapter;
import com.example.asus1.trainticket.ContentUtill.SystemManager;
import com.example.asus1.trainticket.Fragments.HappyFragment;
import com.example.asus1.trainticket.Fragments.MovieTicketFragment;
import com.example.asus1.trainticket.Fragments.TrainTicketFragment;
import com.example.asus1.trainticket.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabLayout.Tab mTrain;
    private TabLayout.Tab mMovie;
    private TabLayout.Tab mHappy;
    private ViewPagerAdapter mViewPagerAdapter;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemManager.Context = this;
        init();
    }

    private void  init(){
        Log.d("aaaaaaa","aaaaaaaa");
        mViewPager = (ViewPager)findViewById(R.id.vp_viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mTrain =mTabLayout.getTabAt(2);
        mMovie = mTabLayout.getTabAt(1);
        mHappy = mTabLayout.getTabAt(0);
        mFragments = new ArrayList<>();
        mFragments.add(new TrainTicketFragment());
        mFragments.add(new MovieTicketFragment());
        mFragments.add(new HappyFragment());
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager()
                ,mFragments);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setCurrentItem(0);

        mTabLayout.setupWithViewPager(mViewPager);
        mTrain.setText(getString(R.string.train)).setIcon(R.mipmap.ic_tain_bule1);
        mMovie.setText(getString(R.string.move)).setIcon(R.mipmap.ic_move1);
        mHappy.setText(getString(R.string.happy)).setIcon(R.mipmap.ic_happy1);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.ic_tain_bule1);

                        mViewPager.setCurrentItem(0);
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.ic_move_bule1);
                        mViewPager.setCurrentItem(1);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.ic_happy_bule1);
                        mViewPager.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.ic_train2);
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.ic_move1);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.ic_happy1);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
