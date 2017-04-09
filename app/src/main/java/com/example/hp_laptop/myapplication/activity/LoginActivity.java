package com.example.hp_laptop.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hp_laptop.myapplication.R;

/**
 * Created by hp_laptop on 2017/2/7.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button loginWithPhone;
    private Button loginWithNothing;
    private ImageView loginWithWechat;
    private ImageView loginWithQq;
    private ImageView loginWithNetEsea;
    private ImageView loginWithMicroBlog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
    }
    private void init(){
        loginWithPhone = (Button) findViewById(R.id.login_with_phone);
        loginWithNothing = (Button) findViewById(R.id.login_with_nothing);
        loginWithWechat = (ImageView) findViewById(R.id.login_with_wechat);
        loginWithQq = (ImageView) findViewById(R.id.login_with_qq);
        loginWithNetEsea = (ImageView) findViewById(R.id.login_with_netease);
        loginWithMicroBlog = (ImageView) findViewById(R.id.login_with_microblog);

        loginWithPhone.setOnClickListener(this);
        loginWithNothing.setOnClickListener(this);
        loginWithWechat.setOnClickListener(this);
        loginWithQq.setOnClickListener(this);
        loginWithNetEsea.setOnClickListener(this);
        loginWithMicroBlog.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //手机号登录
            case R.id.login_with_phone:
                break;
            //随便看看
            case R.id.login_with_nothing:
                Intent intent = new Intent(LoginActivity.this,MainTabActivity.class);
                startActivity(intent);
                break;
            //微信登录
            case R.id.login_with_wechat:
                break;
            //qq登录
            case R.id.login_with_qq:
                break;
            //网易登录
            case R.id.login_with_netease:
                break;
            //微博登录
            case R.id.login_with_microblog:
                break;
        }
    }
}
