package com.example.hp_laptop.myapplication.activity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp_laptop.myapplication.R;
import com.example.hp_laptop.myapplication.adapter.ViewPagerAdapter;
import com.example.hp_laptop.myapplication.fragment.FirstFragment;
import com.example.hp_laptop.myapplication.fragment.ForthFragment;
import com.example.hp_laptop.myapplication.fragment.SecondFragment;
import com.example.hp_laptop.myapplication.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 * Created by haungxl on 2017/2/13.
 */

public class MainTabActivity extends FragmentActivity implements View.OnClickListener{
    private ImageView more;
    private TextView title;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton homePage;
    private RadioButton iphonePage;
    private RadioButton talkPage;
    private RadioButton myselfPage;
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_activity);
        init();
        initData();
    }

    private void init(){
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        homePage = (RadioButton) findViewById(R.id.radio1);
        iphonePage = (RadioButton) findViewById(R.id.radio2);
        talkPage = (RadioButton) findViewById(R.id.radio3);
        myselfPage = (RadioButton) findViewById(R.id.radio4);

        title = (TextView) findViewById(R.id.title_name);
        more = (ImageView) findViewById(R.id.more);
    }

    private void initData(){


        fragmentList = new ArrayList<>();
        fragmentList.add(new FirstFragment(this));
        fragmentList.add(new SecondFragment(this));
        fragmentList.add(new ThirdFragment(this));
        fragmentList.add(new ForthFragment(this));

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        homePage.setOnClickListener(this);
        iphonePage.setOnClickListener(this);
        talkPage.setOnClickListener(this);
        myselfPage.setOnClickListener(this);

        viewPager.setCurrentItem(0);
        radioGroup.check(R.id.radio1);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    radioGroup.check(R.id.radio1);
                }else if (position == 1){
                    radioGroup.check(R.id.radio2);
                }else if (position == 2){
                    radioGroup.check(R.id.radio3);
                }else if (position == 3){
                    radioGroup.check(R.id.radio4);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.radio3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.radio4:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}
