package com.example.asus1.trainticket.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus1.trainticket.Moduls.TrainData_modul;
import com.example.asus1.trainticket.Moduls.TrainPriceModul;
import com.example.asus1.trainticket.Moduls.TrainlList_modul;
import com.example.asus1.trainticket.R;

import java.util.List;

/**
 * Created by asus1 on 2017/11/28.
 */

public class View_train_item extends RelativeLayout {

    private TextView mStartTime;
    private TextView mEndTime;
    private TextView mWuzuo;
    private ImageView mStartImage;
    private ImageView mEndImage;
    private TextView mStartStation;
    private TextView mEndStation;
    private TextView mYingzuo;
    private TextView mCheci;
    private TextView mDuration;
    private TextView mYingwo;
    private TextView mPrice;
    private TextView mRuanwo;
    private Context mContext;
    private TextView mSeet1,mSeet2,mSeet3,mSeet4;

    public View_train_item(Context context) {
        this(context,null);
    }

    public View_train_item(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_train_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    private void init(){

        View view =LayoutInflater.from(mContext).inflate(R.layout.view_train_item,this,false);

        mStartTime = (TextView)view.findViewById(R.id.tv_startTime);
        mEndTime = (TextView)view.findViewById(R.id.tv_endTime);
        mWuzuo = (TextView)view.findViewById(R.id.tv_wuzyo);
        mSeet1 = (TextView)view.findViewById(R.id.tv_seet1);
        mSeet2 = (TextView)view.findViewById(R.id.tv_seet2);
        mSeet3 = (TextView)view.findViewById(R.id.tv_seet3);
        mSeet4 = (TextView)view.findViewById(R.id.tv_seet4);
        mStartStation = (TextView)view.findViewById(R.id.tv_startStation);
        mEndStation = (TextView)view.findViewById(R.id.tv_endStation);
        mYingzuo = (TextView)view.findViewById(R.id.tv_yingzuo);
        mCheci = (TextView)view.findViewById(R.id.tv_banci);
        mDuration = (TextView)view.findViewById(R.id.tv_train_duration);
        mYingwo = (TextView)view.findViewById(R.id.tv_yingwo);
        mPrice = (TextView)view.findViewById(R.id.tv_train_price);
        mRuanwo = (TextView)view.findViewById(R.id.tv_ruanwo);

    }

    public void setData(TrainlList_modul data){

        mStartTime.setText(data.getmStartTime());
        mEndTime.setText(data.getmEndTime());
        mStartStation.setText(data.getmStartStation());
        mEndStation.setText(data.getmEndStation());
        mDuration.setText(data.getmDuration());
        List<TrainPriceModul> priceModuls = data.getmPrices();
        setSeat(priceModuls);


    }

    private void setSeat(List<TrainPriceModul> priceModuls){
        TrainPriceModul modul;
        TrainPriceModul modu2;
        TrainPriceModul modu3 ;
        TrainPriceModul modu4 ;
        switch (priceModuls.size()){
            case 1:
                modul = priceModuls.get(0);
                mSeet1.setText(modul.getmSeatName());
                mWuzuo.setText(modul.getmLeftNum());
                mSeet1.setVisibility(VISIBLE);
                mWuzuo.setVisibility(VISIBLE);
                mPrice.setText(String.valueOf(modul.getmPrice()));
                break;
            case 2:
                modul = priceModuls.get(0);
                mSeet1.setText(modul.getmSeatName());
                mWuzuo.setText(modul.getmLeftNum());
                modu2 = priceModuls.get(1);
                mSeet2.setText(modu2.getmSeatName());
                mYingzuo.setText(modu2.getmLeftNum());
                mSeet1.setVisibility(VISIBLE);
                mWuzuo.setVisibility(VISIBLE);
                mSeet2.setVisibility(VISIBLE);
                mYingzuo.setVisibility(VISIBLE);
                mPrice.setText(String.valueOf(modul.getmPrice()));
                break;
            case 3:
                modul = priceModuls.get(0);
                mSeet1.setText(modul.getmSeatName());
                mWuzuo.setText(modul.getmLeftNum());
                modu2 = priceModuls.get(1);
                mSeet2.setText(modu2.getmSeatName());
                mYingzuo.setText(modu2.getmLeftNum());
                modu3 = priceModuls.get(2);
                mSeet3.setText(modu3.getmSeatName());
                mYingwo.setText(modu3.getmLeftNum());
                mSeet1.setVisibility(VISIBLE);
                mWuzuo.setVisibility(VISIBLE);
                mSeet2.setVisibility(VISIBLE);
                mYingzuo.setVisibility(VISIBLE);
                mSeet3.setVisibility(VISIBLE);
                mYingwo.setVisibility(VISIBLE);
                mPrice.setText(String.valueOf(modul.getmPrice()));
                break;

            case 4:
                modul = priceModuls.get(0);
                mSeet1.setText(modul.getmSeatName());
                mWuzuo.setText(modul.getmLeftNum());
                modu2 = priceModuls.get(1);
                mSeet2.setText(modu2.getmSeatName());
                mYingzuo.setText(modu2.getmLeftNum());
                modu3 = priceModuls.get(2);
                mSeet3.setText(modu3.getmSeatName());
                mYingwo.setText(modu3.getmLeftNum());
                modu4 = priceModuls.get(3);
                mSeet4.setText(modu4.getmSeatName());
                mRuanwo.setText(modu4.getmLeftNum());
                mSeet1.setVisibility(VISIBLE);
                mWuzuo.setVisibility(VISIBLE);
                mSeet2.setVisibility(VISIBLE);
                mYingzuo.setVisibility(VISIBLE);
                mSeet3.setVisibility(VISIBLE);
                mYingwo.setVisibility(VISIBLE);
                mSeet4.setVisibility(VISIBLE);
                mRuanwo.setVisibility(VISIBLE);
                mPrice.setText(String.valueOf(modul.getmPrice()));
                break;
        }

    }

}
