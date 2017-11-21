package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by asus1 on 2017/11/21.
 */

public class ViewpagerRuns extends View {

    private Context mContext;

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

    }
}
