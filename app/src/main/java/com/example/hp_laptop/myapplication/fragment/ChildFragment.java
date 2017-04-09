package com.example.hp_laptop.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp_laptop.myapplication.R;
import com.example.hp_laptop.myapplication.Uitls.HttpUtils.GsonHelper;
import com.example.hp_laptop.myapplication.Uitls.HttpUtils.HttpUtils;
import com.example.hp_laptop.myapplication.Uitls.ResourceUtil;
import com.example.hp_laptop.myapplication.adapter.ChildDetailsAdapter;
import com.example.hp_laptop.myapplication.common.NewsInner;
import com.example.hp_laptop.myapplication.common.NewsMiddle;
import com.example.hp_laptop.myapplication.common.data.DatabaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp_laptop on 2017/3/23.
 */

public class ChildFragment extends Fragment {
    private ListView listView;
    private List<NewsInner> innerList;//新闻数据
    private Context context;
    public ChildFragment(Context context,List<NewsInner> innerList){
        this.context = context;
        this.innerList = innerList;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment,null);
        listView = (ListView) view.findViewById(R.id.home_list);

        innerList = new ArrayList<>();
        innerList = DatabaseHelper.getInstance(context).selectNewsByType(HttpUtils.TOP_TYPE,context);

        ChildDetailsAdapter adapter = new ChildDetailsAdapter(context,innerList);
        listView.setAdapter(adapter);

        return view;
    }


}
