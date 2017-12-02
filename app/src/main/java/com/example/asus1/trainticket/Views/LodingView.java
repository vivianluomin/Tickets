package com.example.asus1.trainticket.Views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/12/2.
 */

public class LodingView extends RelativeLayout {
    private ImageView mRectangle;
    private ImageView mCricle;
    private ImageView mTriangle;
    private ImageView mBottomView;
    private AnimatorSet mAllSet;
    private AnimatorSet mViewSet;
    private int mWdith;
    private int mHeigth;
    private ObjectAnimator mRetangleAnim;
    private ObjectAnimator mCricleAnim;
    private ObjectAnimator mTriangleAnim;
    private ObjectAnimator mBottomAnim;

    private Context mContext;

    public LodingView(Context context) {
        this(context,null);
    }

    public LodingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LodingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mWdith = 50;
        mHeigth = 50;
        init();
    }

    private void init(){

        LayoutParams mParam = new LayoutParams(dip2px(mWdith),dip2px(mHeigth));
        mParam.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        mParam.topMargin = 5;
        mRectangle = new ImageView(mContext);
        mRectangle.setBackgroundResource(R.mipmap.ic_retangle);
        mRectangle.setId(R.id.iv_retangle);
        mRectangle.setLayoutParams(mParam);
        mCricle = new ImageView(mContext);
        mCricle.setBackgroundResource(R.mipmap.ic_cricle);
        mCricle.setLayoutParams(mParam);
        mTriangle = new ImageView(mContext);
        mTriangle.setBackgroundResource(R.mipmap.ic_triangle);
        mTriangle.setLayoutParams(mParam);
        mBottomView = new ImageView(mContext);
        mBottomView.setBackgroundResource(R.drawable.ic_bottomview);
        LayoutParams params = new LayoutParams(dip2px(mWdith),3);
        params.addRule(RelativeLayout.BELOW,R.id.iv_retangle);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        params.topMargin = dip2px(200);
        mBottomView.setLayoutParams(params);
        addView(mRectangle);
        addView(mCricle);
        addView(mTriangle);
        addView(mBottomView);
        mCricle.setVisibility(INVISIBLE);
        mTriangle.setVisibility(INVISIBLE);
        setAnimation();
    }

    private int dip2px(int dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
    }

    private void setAnimation(){
        mRetangleAnim = getShapeAni(mRectangle);
        mRetangleAnim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                mRectangle.setVisibility(VISIBLE);
                mCricle.setVisibility(INVISIBLE);
                mTriangle.setVisibility(INVISIBLE);

                super.onAnimationStart(animation);
            }

        });
        mCricleAnim = getShapeAni(mCricle);
        mCricleAnim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                mRectangle.setVisibility(INVISIBLE);
                mCricle.setVisibility(VISIBLE);
                mTriangle.setVisibility(INVISIBLE);
                super.onAnimationStart(animation);
            }
        });
        mTriangleAnim = getShapeAni(mTriangle);
        mTriangleAnim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {

                mRectangle.setVisibility(INVISIBLE);
                mCricle.setVisibility(INVISIBLE);
                mTriangle.setVisibility(VISIBLE);
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mViewSet = new AnimatorSet();
                mViewSet.playTogether(mRetangleAnim,mBottomAnim);
                mViewSet.play(mCricleAnim).after(mRetangleAnim);
                mViewSet.play(mTriangleAnim).after(mCricleAnim);
                mViewSet.start();
            }
        });

        mBottomAnim = ObjectAnimator.ofFloat(mBottomView,"scaleX",1.0f,0.3f);
        mBottomAnim.setDuration(1000);
        mBottomAnim.setRepeatCount(ValueAnimator.INFINITE);
        mBottomAnim.setRepeatMode(ValueAnimator.RESTART);
        mBottomAnim.setInterpolator(new AccelerateDecelerateInterpolator());

        mViewSet = new AnimatorSet();
        mViewSet.playTogether(mRetangleAnim,mBottomAnim);
        mViewSet.play(mCricleAnim).after(mRetangleAnim);
        mViewSet.play(mTriangleAnim).after(mCricleAnim);
        mViewSet.start();


    }


    private ObjectAnimator getShapeAni(View object){
        PropertyValuesHolder tran = PropertyValuesHolder.ofFloat("translationY",this.getTop()+dip2px(100),dip2px(200));
        PropertyValuesHolder rota  = PropertyValuesHolder.ofFloat("rotation",0,360);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(object,tran,rota);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());

        return animator;

    }



}
