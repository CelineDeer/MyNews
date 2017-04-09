package com.example.hp_laptop.myapplication.Uitls.PreferenceUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hp_laptop on 2017/2/8.
 */

public class PreferenceUtil {
    public static String PREFERENCE_IS_FIRST_IN = "is_first_in";
    public static String IS_FIRST_IN = "isFirst";

    public static void setFirstIn (Context context,Boolean isfirst){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_IS_FIRST_IN,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_IN,isfirst);
        editor.commit();
    }
    public static Boolean getFirstIn(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_IS_FIRST_IN,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(IS_FIRST_IN,true);
    }


}
