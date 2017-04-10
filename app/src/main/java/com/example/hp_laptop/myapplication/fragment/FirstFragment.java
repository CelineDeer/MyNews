package com.example.hp_laptop.myapplication.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;

import com.astuetz.PagerSlidingTabStrip;
import com.example.hp_laptop.myapplication.R;
import com.example.hp_laptop.myapplication.Uitls.HttpUtils.HttpUtils;
import com.example.hp_laptop.myapplication.Uitls.ResourceUtil;
import com.example.hp_laptop.myapplication.adapter.ChildViewPagerAdapter;
import com.example.hp_laptop.myapplication.common.NewsInner;
import com.example.hp_laptop.myapplication.common.data.DatabaseHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第一个界面
 * Created by hxl on 2017/2/13.
 */

public class FirstFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;//刷新控件
    private PagerSlidingTabStrip pst;//标题控件
    private ViewPager childViewPager;//子viewpager
    private Context context;
    private List<NewsInner> newsInners = new ArrayList<>();//新闻详细信息集合


    public FirstFragment(Context context){
        this.context = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.first_fragment,null);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        pst = (PagerSlidingTabStrip) view.findViewById(R.id.pst);
        childViewPager = (ViewPager) view.findViewById(R.id.child_vp);


        initData();

        ChildViewPagerAdapter adapter = new ChildViewPagerAdapter(getChildFragmentManager(),context,newsInners);
        childViewPager.setAdapter(adapter);

        pst.setViewPager(childViewPager);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);

        return view;
    }

    @Override
    public void onRefresh() {

        //刷新完成
    }
    private void initData(){
        Log.e("SIZE",""+newsInners.size());

    }
}
