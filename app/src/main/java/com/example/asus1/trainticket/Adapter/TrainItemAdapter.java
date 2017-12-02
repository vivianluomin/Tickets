package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.TrainItemHolder;
import com.example.asus1.trainticket.Moduls.Train_modul;
import com.example.asus1.trainticket.Moduls.TrainlList_modul;
import com.example.asus1.trainticket.Views.View_train_item;

import java.util.List;

/**
 * Created by asus1 on 2017/11/30.
 */

public class TrainItemAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private Train_modul mTrainModul;
    private List<TrainlList_modul> mModulList;

    public TrainItemAdapter(Context context, List<TrainlList_modul> lists) {
        mContext = context;
        mModulList = lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainItemHolder(new View_train_item(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TrainItemHolder)holder).setData(mModulList.get(position));


    }

    @Override
    public int getItemCount() {
        return mModulList.size();
    }
}
