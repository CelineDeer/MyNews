package com.example.hp_laptop.myapplication.common;

/**
 * Created by hp_laptop on 2017/3/31.
 */

public class Outer {
    String code;
    String message;
    String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return " code:"+code+" message:"+message+" url:"+url;
    }
}
