package com.example.hp_laptop.myapplication.Uitls.HttpUtils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.hp_laptop.myapplication.R;
import com.example.hp_laptop.myapplication.common.NewsInner;
import com.example.hp_laptop.myapplication.common.NewsMiddle;
import com.example.hp_laptop.myapplication.common.NewsOuter;
import com.example.hp_laptop.myapplication.common.Outer;
import com.example.hp_laptop.myapplication.common.data.DatabaseHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求类
 * Created by hxl on 2017/3/27.
 */

public class HttpUtils {
    public static final String TOP_TYPE = "top";//头条
    public static final String SHEHUI_TYPE = "shehui";//社会
    public static final String GUONEI_TYPE = "guonei";//国内
    public static final String GUOJI_TYPE = "guoji";//国际
    public static final String YULE_TYPE = "yule";//娱乐
    public static final String TIYU_TYPE = "tiyu";//体育
    public static final String JUNSHI_TYPE = "junshi";//军事
    public static final String KEJI_TYPE = "keji";//科技
    public static final String CAIJING_TYPE = "caijing";//财经
    public static final String SHISHANG_TYPE = "shishang";//时尚

    private static HttpUtils uniqueHttpUtils = null;
    private HttpUtils(){
    }


    public static HttpUtils getInstance(){
        Object obj = new Object();
        synchronized (obj) {
            if (uniqueHttpUtils == null) {
                synchronized (obj) {
                    uniqueHttpUtils = new HttpUtils();
                }
            }
        }
        return uniqueHttpUtils;
    }



    /**
     * @param url 请求地址
     * @param key 应用APPKEY
     * @param type 新闻类型
     * */
    public  void request(String url, String key, String type, final Context context){
        final String requestBody = "?type="+type+"&key="+key;
        OkHttpClient okHttpClient = new OkHttpClient();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        stringBuilder.append(requestBody);
        //请求
        Request request = new Request.Builder().url(stringBuilder.toString())
                .build();
        //回调
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                NewsOuter newsOuter = gson.fromJson(response.body().string(),NewsOuter.class);
                if (newsOuter.getReason().equals(context.getResources().getString(R.string.reason))){
                    NewsMiddle newsMiddle = newsOuter.getResult();
                    List<NewsInner> innerList = newsMiddle.getData();

                    //存入的数据库
                    saveAsDatabase(context,innerList);
                }
            }
        });
    }
    //将获取到的信息存入数据库
    public void saveAsDatabase(Context context,List<NewsInner> inners){
        for (int i = 0;i< inners.size();i++){
            DatabaseHelper.getInstance(context).saveNewsInfo(context,
                    inners.get(i).getUniquekey(),
                    inners.get(i).getTitle(),
                    inners.get(i).getDate(),
                    inners.get(i).getCategory(),
                    inners.get(i).getAuthor_name(),
                    inners.get(i).getUrl(),
                    inners.get(i).getThumbnail_pic_s(),
                    inners.get(i).getThumbnail_pic_s02(),
                    inners.get(i).getThumbnail_pic_s03()
            );
        }
    }
}
