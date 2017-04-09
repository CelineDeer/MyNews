package com.example.hp_laptop.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_laptop.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;

/**
 * Created by hp_laptop on 2017/2/8.
 */

public class BgaBannerActivity extends AppCompatActivity {
    private BGABanner bgaBanner;
    private TextView timeCount;
    private  int totalTime = 5;
    Timer timer = new Timer();
    private static int[] picture = {R.mipmap.pic_one,R.mipmap.pic_two,R.mipmap.pic_three};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bgabanner);
        initView();
    }
    private void initView(){
        bgaBanner = (BGABanner) findViewById(R.id.banner);
        //轮播图切换模式
        bgaBanner.setTransitionEffect(TransitionEffect.Flip);
        bgaBanner.setPageChangeDuration(2000);
        bgaBanner.setAllowUserScrollable(false);

        bgaBanner.setData(picture);
        timeCount = (TextView) findViewById(R.id.time_count);
        timeCount.setBackgroundColor(Color.argb(20,0,0,0));
        timer.schedule(timerTask,0,2000);

        timeCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BgaBannerActivity.this,LoginActivity.class);
                startActivity(intent);
                timerTask.cancel();
                finish();
            }
        });
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    totalTime--;
                    timeCount.setText(""+totalTime+"s 跳过");
                    if (totalTime<1){
                        timer.cancel();
                        finish();
                        Intent intent = new Intent(BgaBannerActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
    };


}
