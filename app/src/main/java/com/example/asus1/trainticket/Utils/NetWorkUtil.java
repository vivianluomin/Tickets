package com.example.asus1.trainticket.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by asus1 on 2017/11/24.
 */

public class NetWorkUtil {

    public  static  boolean IfHasNetWork(Context context){

        ConnectivityManager manager =  (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager == null){
            return  false;
        }
        NetworkInfo info =  manager.getActiveNetworkInfo();
        if(info!=null && info.isConnected()){
            if(info.getState() == NetworkInfo.State.CONNECTED){
                return  true;
            }
        }

        return  false;
    }

}
