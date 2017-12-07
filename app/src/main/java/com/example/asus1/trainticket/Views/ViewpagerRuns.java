package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
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
    private int[] mIds = null;
    private Handler handler ;

    private boolean isDragging = false;
    private boolean isStop = false;
    private boolean isStart = false;

    private int mCurrentItem = 0;


    //请求更新显示的View。
    private static final int MSG_UPDATE = 1;
    //请求暂停轮播。
    public static final int MSG_STOP = 2;
    //请求恢复轮播。
    public static final int MSG_REGAIN = 3;



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
        mViewPager.setOffscreenPageLimit(3);

        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(mViewPager == null || handler == null|| mAdapter == null || isDragging){
                    return;
                }

                switch (msg.what){
                    case MSG_UPDATE:
                        if(isStop || hasMessages(MSG_UPDATE)){
                            return;
                        }

                        if(mAdapter.getCount()>1){
                            mCurrentItem ++;
                            mCurrentItem %= mAdapter.getCount();
                            mViewPager.setCurrentItem(mCurrentItem);
                            sendEmptyMessageDelayed(MSG_UPDATE,3000);
                        }
                        break;
                    case MSG_STOP:
                        if(hasMessages(MSG_UPDATE)){
                            removeMessages(MSG_UPDATE);
                        }

                        isStop = true;
                        break;

                    case MSG_REGAIN:
                        if(hasMessages(MSG_UPDATE)){
                            removeMessages(MSG_UPDATE);
                        }
                        sendEmptyMessageDelayed(MSG_UPDATE,3000);
                        isStop = false;
                        break;

                }

            }
        };

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(state == ViewPager.SCROLL_STATE_DRAGGING){
            isDragging = true;
        }else if(state == ViewPager.SCROLL_STATE_IDLE){

            mCurrentItem = mViewPager.getCurrentItem();
            if(isDragging&&handler!=null){
                handler.sendEmptyMessageDelayed(MSG_UPDATE,3000);
            }

            isDragging = false;

        }
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
      if(mIds!=null&&mIds.length>0){
          ((ViewPagerFragment) mFragments.get(position)).setData(mIds[position]);
      }


    }





    public void setData(int[] ids){
        mIds = ids;
        for(int i = 0;i<ids.length;i++){

            ((ViewPagerFragment) mFragments.get(i)).setData(ids[i]);
        }

        handler.sendEmptyMessageDelayed(MSG_UPDATE,3000);
    }




}
