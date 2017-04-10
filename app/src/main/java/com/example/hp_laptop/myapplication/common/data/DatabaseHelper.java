package com.example.hp_laptop.myapplication.common.data;


import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hp_laptop.myapplication.common.NewsInner;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

/**
 * 数据库存储类
 * Created by hxl on 2017/4/5.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String NEWS_LIST_NAME = "news";//数据库名称
    private static final int NEWS_LIST_VERSION = 1;//数据库版本
    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseHelper uniqueDbhelper = null;




    public DatabaseHelper(Context context) {
        super(context, NEWS_LIST_NAME, null, NEWS_LIST_VERSION);
    }



    public static DatabaseHelper getInstance(Context context){

        synchronized (DatabaseHelper.class) {
            if (uniqueDbhelper == null){
                uniqueDbhelper = new DatabaseHelper(context);
            }
        }
        return uniqueDbhelper;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NEWS_LIST_NAME+" ("
                + "uniquekey TEXT PRIMARY KEY , "
                + "title TEXT, "
                + "date TEXT, "
                + "category TEXT, "
                + "author_name TEXT, "
                + "url TEXT, "
                + "thumbnail_pic_s TEXT, "
                + "thumbnail_pic_s02 TEXT, "
                + "thumbnail_pic_s03 TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    private void init(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }



    //根据类型选择新闻
    public List<NewsInner> selectNewsByType(String newsType,Context context,int limitSize){
        List<NewsInner> result = new ArrayList<>();
        if (sqLiteDatabase != null){
            Log.e("selectNewsByType","before");
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM "+NEWS_LIST_NAME+" limit "+limitSize,null);
            Log.e("selectNewsByType","after");
            if (c == null){
                Log.e("cursor","cursur is null");
                return null;
            }
            Log.e("Curcor.count",""+c.getColumnCount());
            while (c.moveToNext()){
                NewsInner newsInner = new NewsInner();
                getNewsInners(newsInner,c);
                result.add(newsInner);
            }
            c.close();
        }

        return result;
    }

    /**
    *将数据存储到数据库
    * @param uniquekey,title,date,category,author_name,url,thumbnail_pic_s
    * */
    public void saveNewsInfo(Context context,String uniquekey,String title,String date,String category,String author_name,String url,String thumbnail_pic_s,String thumbnail_pic_s02,String thumbnail_pic_s03){
       init(context);
        if (sqLiteDatabase != null){
            try {
                String insertSql = "INSERT OR REPLACE INTO "+NEWS_LIST_NAME+" (uniquekey,title,date,category,author_name,url,thumbnail_pic_s,thumbnail_pic_s02,thumbnail_pic_s03) VALUES(?,?,?,?,?,?,?,?,?)";
                sqLiteDatabase.execSQL(insertSql,
                        new String[] {
                                uniquekey,
                                title,
                                date,
                                category,
                                author_name,
                                url,
                                thumbnail_pic_s,
                                thumbnail_pic_s02,
                                thumbnail_pic_s03 });
            } catch (SQLException e) {
                Log.e("DatabaseHelper","[saveNewsInfo] has exception"+e.getMessage());
                e.printStackTrace();
            }
        }

    }


    /**
     * @param inner 存储新闻的实体类
     * */
    private void getNewsInners(NewsInner inner,Cursor c){
        Log.e("category",""+c.getString(c.getColumnIndex("category")));
        inner.setTitle(c.getString(c.getColumnIndex("title")));
        inner.setDate(c.getString(c.getColumnIndex("date")));
        inner.setCategory(c.getString(c.getColumnIndex("category")));
        inner.setAuthor_name(c.getString(c.getColumnIndex("author_name")));
        inner.setThumbnail_pic_s(c.getString(c.getColumnIndex("thumbnail_pic_s")));
        inner.setUrl(c.getString(c.getColumnIndex("url")));
    }
}
