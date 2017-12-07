package com.example.asus1.trainticket.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus1.trainticket.Moduls.JokeGroup;
import com.example.asus1.trainticket.Moduls.JokingData;
import com.example.asus1.trainticket.Views.View_Joking;

/**
 * Created by asus1 on 2017/12/7.
 */

public class JokingDataHolder extends RecyclerView.ViewHolder {

    private View_Joking view;

    public JokingDataHolder(View itemView) {
        super(itemView);
        view = (View_Joking)itemView;
    }

    public void  setData(JokeGroup data){
        view.setData(data);
    }
}
