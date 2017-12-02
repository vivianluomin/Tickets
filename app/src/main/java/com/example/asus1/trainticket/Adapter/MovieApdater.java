package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.asus1.trainticket.Holder.HeadHolder;
import com.example.asus1.trainticket.Holder.ItemHolder;
import com.example.asus1.trainticket.Moduls.Movie_subject;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.View_Movie_item;
import com.example.asus1.trainticket.Views.ViewpagerRuns;

import java.util.List;

/**
 * Created by asus1 on 2017/11/23.
 */

public class MovieApdater extends RecyclerView.Adapter {


    private Context mContext;
    private FragmentManager mFm;
    private List<Movie_subject> mSubjects;
    private final  int mHEAD = 0;
    private final  int mITEM = 1;

    public MovieApdater(Context context, List<Movie_subject> subjects, FragmentManager fm) {
        mContext = context;
        mFm = fm;
        mSubjects  = subjects;

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return mHEAD;
        }
        return mITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == mHEAD){
            return new HeadHolder(new ViewpagerRuns(mContext,mFm));
        }


        return  new ItemHolder(new View_Movie_item(mContext));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position == 0){
            int[] ids = new int[4];
            for(int i = 0;i<mSubjects.size()&&i<4;i++){
                ids[i] = mSubjects.get(i).getId();

            }
            ((HeadHolder)(holder)).setData(ids);
        }else{

            ((ItemHolder)holder).setData(mSubjects.get(position));
        }

    }

    @Override
    public int getItemCount() {

        return mSubjects.size()+1;
    }
}
