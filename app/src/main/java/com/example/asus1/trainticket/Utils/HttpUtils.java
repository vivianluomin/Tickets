package com.example.asus1.trainticket.Utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asus1 on 2017/11/24.
 */

public class HttpUtils {

    private static OkHttpClient client = new OkHttpClient();

    public  static void Request(String url, final CallBackLinstener callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(call);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    callback.onResponse(call,response);
            }
        });
    }

    public interface CallBackLinstener{
        void onFailure(Call call);
        void onResponse(Call call,Response response);
    }

}
