package com.example.asus1.trainticket.Views;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;

import com.example.asus1.trainticket.ContentUtill.SystemManager;
import com.example.asus1.trainticket.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by asus1 on 2017/11/25.
 */

public class Calendar_Dialog extends Dialog {

    private Context mContext;
    private CalendarView mCalendar;
    private CalenderLinseter mCalendarListener;

    public Calendar_Dialog(@NonNull Context context) {
        this(context,0);
    }

    public Calendar_Dialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        init();
    }

    private void init(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_calender,null);
        mCalendar = (CalendarView)view.findViewById(R.id.calendar);
       setContentView(view);
        setListenr();
    }

    private void setListenr(){
        mCalendar.setDate(System.currentTimeMillis());
        mCalendar.setMinDate(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(Calendar.MONTH,3);
        mCalendar.setMaxDate(calendar.getTime().getTime());
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                if(mCalendarListener!=null){
                    String date = i+"-"+((i1 + 1) < 10 ? "0" + (i1 + 1) : (i1 + 1)) + "-" + (i2 < 10 ? "0" + i2: i2);
                    mCalendarListener.getSelectedData(date);
                }
            }
        });
    }

    public void setCalendarListener(CalenderLinseter calendarListener){
        mCalendarListener = calendarListener;
    }

    public  interface CalenderLinseter{
        void  getSelectedData(String date);
    }


}

