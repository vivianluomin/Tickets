package com.example.asus1.trainticket.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.example.asus1.trainticket.ContentUtill.Constants;
import com.example.asus1.trainticket.Moduls.Weaher_now;
import com.example.asus1.trainticket.Moduls.Weather;
import com.example.asus1.trainticket.Moduls.Weather_basic;
import com.example.asus1.trainticket.Moduls.Weather_data;
import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Utils.NetWorkUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/18.
 */

public class TrainTicketFragment extends Fragment implements BDLocationListener{

    private ImageView mHeadImage;
    private ImageView mWeatherImage;
    private TextView mWeatherTime;
    private TextView mWeatherDate;
    private TextView mWeatherArear;

    private EditText mStartStation;
    private EditText mEndStation;
    private EditText mGoTime;
    private TextView mSearch;
    private CheckedTextView mStudent;
    private LocationClient mLocationClient;
    private String mCity;
    private String mDistrict;
    private Weather_basic mBasic;
    private Weaher_now mNow;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mLocationClient = new LocationClient(getActivity());
        mLocationClient.registerLocationListener(this);
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_train,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        mHeadImage = (ImageView)view.findViewById(R.id.iv_head_bg);
        Glide.with(getContext())
                .load(Constants.TARIN_BG)
                .placeholder(R.drawable.view_loading)
                .error(R.mipmap.bg_failed)
                .into(mHeadImage);

        mWeatherImage = (ImageView)view.findViewById(R.id.iv_weather);
        mWeatherTime = (TextView)view.findViewById(R.id.tv_time);
        mWeatherDate = (TextView)view.findViewById(R.id.tv_weather_data);
        mWeatherArear = (TextView)view.findViewById(R.id.tv_arear);

        mStartStation = (EditText)view.findViewById(R.id.et_start_station);
        mEndStation = (EditText)view.findViewById(R.id.et_end_station);
        mGoTime = (EditText)view.findViewById(R.id.et_start_time);
        mSearch = (TextView)view.findViewById(R.id.tv_train_search);
        mStudent = (CheckedTextView)view.findViewById(R.id.ctv_check);
        LocationManager manager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            getPermission();
        }else{
            Toast.makeText(getContext(),"youdududu",Toast.LENGTH_SHORT).show();
        }

    }

    private void getPermission(){
        final List<String> permissionsList = new ArrayList<>();

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            permissionsList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
            permissionsList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        String[] permissions = permissionsList.toArray(new String[permissionsList.size()]);

        if(!permissionsList.isEmpty()){
           ActivityCompat.requestPermissions(getActivity(),permissions,1);
        }else {
            setData();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                for(int i = 0;i<grantResults.length;i++){
                    if(grantResults[i]!= PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getContext(),"你拒绝了定位",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                setData();
        }
    }

    private void setData(){
        if(NetWorkUtil.IfHasNetWork(getContext())){
            getDataFrommNetwork();
        }else{
            getDataFromDatabase();
        }
    }

    private void getDataFrommNetwork(){

        mLocationClient.start();

    }

    private void getDataFromDatabase(){

    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        mCity = bdLocation.getCity();
        mDistrict = bdLocation.getDistrict();
        Log.d("aaaa",mCity+" ddd "+mDistrict);
        String url= "";
        if(mDistrict!=null&&!mDistrict.equals("")){
            url = Constants.Weather+Constants.Params+mDistrict;
        }else if(mCity!=null&&!mCity.equals("")){
            url = Constants.Weather+Constants.Params+mCity;
        }else {
            Toast.makeText(getContext(),getString(R.string.cannotLocation)+bdLocation.getCity(),Toast.LENGTH_SHORT).show();
            return;
        }

        HttpUtils.Request(url,WeatherCallback);

    }

    private void handleData(){
        String erear="";
        String weather="";
        if(mBasic!=null){
            erear+=mBasic.getmLocation();
            mWeatherArear.setText(erear);
        }
        if(mNow!=null){
            Glide.with(getContext())
                    .load(Constants.Weather_ICON+mNow.getmWeather_icon()+".png")
                    .into(mWeatherImage);
            weather+=mNow.getmWeather_data();
            weather+="  ";
            weather+=mNow.getmTmp();
            weather+=getString(R.string.sheshidu);
            mWeatherDate.setText(weather);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String data = dateFormat.format(new Date(System.currentTimeMillis()));
        mWeatherTime.setText(data);

    }

    HttpUtils.CallBackLinstener WeatherCallback = new HttpUtils.CallBackLinstener() {
        @Override
        public void onFailure(Call call) {

        }

        @Override
        public void onResponse(Call call, Response response) {
            try {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Weather weather = gson.fromJson(response.body().string(),Weather.class);
                if(weather!=null){
                    JsonElement[] jsonObjects = weather.getHeWeather6();
                    Weather_data data = gson.fromJson(jsonObjects[0],Weather_data.class);
                    mBasic = data.getBasic();
                    mNow = data.getNow();
                    handleData();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    };



}
