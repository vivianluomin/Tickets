package com.example.asus1.trainticket.Utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by asus1 on 2017/11/25.
 */

public class KeyBoradUtil {

    public static void KeyBroadHind(Context context,View view){
        InputMethodManager methodManager =(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(methodManager!=null){
            methodManager.hideSoftInputFromInputMethod(view.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }

    }

}
