package com.example.hp_laptop.myapplication.common;

import java.util.List;

/**
 * Created by hp_laptop on 2017/3/24.
 */

public class NewsOuter {
    String reason;
    NewsMiddle result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewsMiddle getResult() {
        return result;
    }

    public void setResult(NewsMiddle result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "reason:"+reason+" result:"+result;
    }
}
