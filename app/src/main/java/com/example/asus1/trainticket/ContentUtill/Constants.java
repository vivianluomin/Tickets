package com.example.asus1.trainticket.ContentUtill;

/**
 * Created by asus1 on 2017/11/20.
 */

public class Constants {

    public  static  String TARIN_BG = "http://guolin.tech/api/bing_pic";
    public  static  String Movie_Now
            = "https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=";

    public static String Movie_BG = "https://api.douban.com/v2/movie/subject/";
    public static String Movie_BG_Param = "/photos?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=1&client=something&udid=dddddddddddddddddddddd";
    public static String Movie_detail = "http://api.douban.com/v2/movie/subject/";
    public static String Movie_deatail_Param = "?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=&udid=";

    public static String Movie_ShortComments = "https://api.douban.com/v2/movie/subject/";
    public static  String Movie_ShortComments_params = "/comments?apikey=0b2bdeda43b5688921839c8ecb20399b&count=20&client=&udid=";

    public static String Movie_Comments = "https://api.douban.com/v2/movie/subject/";
    public static String Movie_Comments_Param = "/reviews?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=20&client=&udid=";

    public static String Movie_Reviews = "https://movie.douban.com/review/";

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

    public static String Joking = "http://is.snssdk.com/neihan/stream/mix/v1/?mpic=1&webp=1&essence=1&content_type=-102&message_cursor=-1&am_longitude=110&am_latitude=120&am_city=%E5%8C%97%E4%BA%AC%E5%B8%82&am_loc_time=1489226058493&count=30&min_time=1489205901&screen_width=1450&do00le_col_mode=0&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120";




}
