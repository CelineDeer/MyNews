package com.example.hp_laptop.myapplication.Uitls.HttpUtils;

import android.content.Context;
import android.util.Log;

import com.example.hp_laptop.myapplication.Uitls.ResourceUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Gson解析
 * Created by hxl on 2017/3/27.
 */
public class GsonHelper<T> {
    private Context context;
    private static GsonHelper uniqueGsonHelper = null;

    public GsonHelper(){}


    public static GsonHelper getInstance(){
        Object obj = new Object();
        synchronized (obj) {
            if (uniqueGsonHelper == null) {
                synchronized (obj) {
                    uniqueGsonHelper = new GsonHelper();
                }
            }
        }
        return uniqueGsonHelper;
    }


}
