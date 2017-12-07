package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.asus1.trainticket.Holder.JokingDataHolder;
import com.example.asus1.trainticket.Moduls.JokeGroup;
import com.example.asus1.trainticket.Moduls.JokingData;
import com.example.asus1.trainticket.Views.View_Joking;

import java.util.List;

/**
 * Created by asus1 on 2017/12/7.
 */

public class JokingDataApdater extends RecyclerView.Adapter {

    private Context mContext;
    private List<JokingData.JokingDatadata> mData;


    public JokingDataApdater(Context context, List<JokingData.JokingDatadata> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokingDataHolder(new View_Joking(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((JokingDataHolder)holder).setData(mData.get(position).getGroup());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
