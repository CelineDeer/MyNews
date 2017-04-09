package com.example.hp_laptop.myapplication.common;

import java.util.List;

/**
 * Created by hp_laptop on 2017/3/24.
 */

public class NewsMiddle {
    String stat;
    List<NewsInner> data;

    public NewsMiddle(String stat,List<NewsInner> data){
        this.stat = stat;
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsInner> getData() {
        return data;
    }

    public void setData(List<NewsInner> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "stat = "+stat+" data = "+data.toString();
    }
}
