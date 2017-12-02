package com.example.asus1.trainticket.ContentUtill;

/**
 * Created by asus1 on 2017/11/20.
 */

public class Constants {

    public  static  String TARIN_BG = "http://cn.bing.com/az/hprichbg/rb/RhoneRiverDusk_ROW9628789736_1920x1080.jpg";
    public  static  String Movie_Now
            = "https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=";


    public static String Weather_ICON = "https://cdn.heweather.com/cond_icon/";

    public static  String Weather
            = "https://free-api.heweather.com/s6/weather/now?";

    public static  String Air
            ="https://free-api.heweather.com/s6/air/now?";

    public static  String Weather_KEY = "f4b64ca6f3734318b7ac8134e54c2cd0";

    public static String Params = "&key="+Weather_KEY+"&location=";

    public static String TRAIN_URL = "http://huoche.tuniu.com/yii.php?r=train/trainTicket/getTickets";
    public static String Train_Time ="&primary%5BdepartureDate%5D=";
    public static String Train_StartCityCode = "&primary%5BdepartureCityCode%5D=";
    public static String Train_StartCityName = "&primary%5BdepartureCityName%5D=";
    public static String Train_EndCityCode = "&primary%5BarrivalCityCode%5D=";
    public static String Train_EdnCityNmae = "&primary%5BarrivalCityName%5D=";
    public static String Train_endParam = "&start=0&limit=0";





}
