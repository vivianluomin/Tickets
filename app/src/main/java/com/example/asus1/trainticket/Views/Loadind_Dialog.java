package com.example.asus1.trainticket.Views;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by asus1 on 2017/12/2.
 */

public class Loadind_Dialog extends Dialog {

    private Context mConext;

    public Loadind_Dialog(@NonNull Context context) {
        super(context);
        mConext = context;
        init();
    }

    private void  init(){
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        DisplayMetrics metrics = mConext.getResources().getDisplayMetrics();
        params.height = (int) (metrics.heightPixels*0.5);
        params.width = (int)(metrics.widthPixels*0.5);
//
//        window.setAttributes(params);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(params.width,params.height);
        setContentView(new LodingView(mConext),layoutParams);
        setCanceledOnTouchOutside(false);


    }
}
