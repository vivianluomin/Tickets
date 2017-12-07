package com.example.asus1.trainticket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.asus1.trainticket.R;
import com.example.asus1.trainticket.Utils.HttpUtils;
import com.example.asus1.trainticket.Views.Loadind_Dialog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class ShowMovieCommentsActivity extends BaseActivity {

    private ImageView mBack;
    private WebView mWebView;
    private String mUrl;
    private WebSettings mSetting;
    private Loadind_Dialog mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movie_comments);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        init();
    }

    private void init(){
        mBack = (ImageView)findViewById(R.id.iv_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mWebView = (WebView)findViewById(R.id.webview);
        mSetting = mWebView.getSettings();
        mSetting.setSupportZoom(false);
        mSetting.setUseWideViewPort(true);
        mSetting.setLoadWithOverviewMode(true);
        mSetting.setLoadsImagesAutomatically(true);
        //mSetting.setTextZoom(200);
        mLoading = new Loadind_Dialog(this);
        requestData();
    }

    private void requestData(){
        mLoading.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document document = Jsoup.connect(mUrl).get();
                    Elements elements = document.select("div#content");
                    if(elements.size()>0){
                        Element ele = elements.get(0);
                       elements = ele.getAllElements();
                       ele = elements.get(2);
                        String h = ele.outerHtml();
                        Elements select = document.select("div.main-bd");
                        ele = select.get(0);
                        final String s = "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no\" />" +
                                "<style>img{max-width:300;max-height:400} </style></head>"
                                +h+ele.outerHtml()+"</html>";
                        ShowMovieCommentsActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mWebView.loadData(s,"text/html","utf-8");
                                mLoading.dismiss();
                            }
                        });

                    }


                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }).start();



    }



}
