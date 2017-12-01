package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.R;

/**
 * Created by asus1 on 2017/12/1.
 */

public class RecyclerViewDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    Drawable mDivider;

    public RecyclerViewDecoration(Context context) {
        mContext = context;
        TypedArray array = mContext.obtainStyledAttributes(new int[]{android.R.attr.listDivider});
        mDivider  = array.getDrawable(0);
        array.recycle();

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for(int i =0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom()+params.bottomMargin;
            int bottom = top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }

        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect,view,parent,state);
        outRect.set(0,0,0,mDivider.getIntrinsicHeight());
    }
}
