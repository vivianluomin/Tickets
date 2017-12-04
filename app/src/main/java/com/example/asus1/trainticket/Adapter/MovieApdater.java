package com.example.asus1.trainticket.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class MovieApdater extends RecyclerView.Adapter implements View.OnClickListener{


    private Context mContext;
    private FragmentManager mFm;
    private List<Movie_subject> mSubjects;
    private final  int mHEAD = 0;
    private final  int mITEM = 1;
    private HeadHolder headHolder;
    private View_Movie_item.RecyclerViewItemListener mRecyclerViewListener = null;

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


        View_Movie_item item =  new View_Movie_item(mContext);
        item.setOnClickListener(this);
        ItemHolder itemHolder = new ItemHolder(item);

        return  itemHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position == 0){

            headHolder = (HeadHolder)holder;
        }else if(position == 1){
            int[] ids = new int[4];
            for(int i = 0;i<mSubjects.size()&&i<4;i++){
                ids[i] = mSubjects.get(i).getId();

            }
            if(headHolder!=null){
                headHolder.setData(ids);
            }


        }

        if(position!=0){


            ((ItemHolder)holder).setData(mSubjects.get(position-1));
            ((ItemHolder)holder).mView.setTag(position-1);

        }

    }

    public void setLintenser(View_Movie_item.RecyclerViewItemListener lintenser){
        mRecyclerViewListener = lintenser;
    }

    @Override
    public void onClick(View v) {

        if(mRecyclerViewListener!=null){
            mRecyclerViewListener.onItemClick((int)v.getTag());
        }
    }

    @Override
    public int getItemCount() {

        return mSubjects.size()+1;
    }
}
