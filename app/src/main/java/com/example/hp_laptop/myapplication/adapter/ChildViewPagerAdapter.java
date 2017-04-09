package com.example.hp_laptop.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp_laptop.myapplication.Uitls.HttpUtils.HttpUtils;
import com.example.hp_laptop.myapplication.common.NewsInner;
import com.example.hp_laptop.myapplication.fragment.ChildFragment;

import java.util.List;

/**
 * 首页的子viewpager适配器
 * Created by hxl on 2017/3/23.
 */

public class ChildViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] title = {"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};
    private List<NewsInner> newsInners;

    public ChildViewPagerAdapter(FragmentManager fm, Context context,List<NewsInner> newsInners) {
        super(fm);
        this.context = context;
        this.newsInners = newsInners;
    }

    @Override
    public Fragment getItem(int position) {
        ChildFragment childFragment = new ChildFragment(context,newsInners);
        return  childFragment;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
