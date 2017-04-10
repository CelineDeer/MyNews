package com.example.hp_laptop.myapplication;

import android.app.Application;
import android.util.Log;

import com.example.hp_laptop.myapplication.Uitls.HttpUtils.HttpUtils;
import com.example.hp_laptop.myapplication.Uitls.ResourceUtil;
import com.example.hp_laptop.myapplication.common.data.DatabaseHelper;

/**
 * Created by huangxl on 2017/3/31.
 */

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //获取数据
        String url = ResourceUtil.getConfString(getApplicationContext(),"news_url");
        String appkey = ResourceUtil.getConfString(getApplicationContext(),"news_appkey");
        HttpUtils.getInstance().request(url,appkey,HttpUtils.TOP_TYPE,getApplicationContext());

        //获取数据
        String url01 = ResourceUtil.getConfString(getApplicationContext(),"news_url");
        String appkey01 = ResourceUtil.getConfString(getApplicationContext(),"news_appkey");
        HttpUtils.getInstance().request(url,appkey,HttpUtils.TOP_TYPE,getApplicationContext());
    }
}
