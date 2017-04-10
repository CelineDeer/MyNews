package com.example.hp_laptop.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp_laptop.myapplication.R;
import com.example.hp_laptop.myapplication.common.NewsInner;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 第一页新闻的adapter
 * Created by hxl on 2017/4/7.
 */

public class ChildDetailsAdapter extends BaseAdapter{
    private Context context;
    private List<NewsInner> innerList;
    private ViewHolder holder;
    private LayoutInflater layoutInflater;

    public ChildDetailsAdapter(Context context,List<NewsInner> innerList){
        this.context = context;
        this.innerList = innerList;
        layoutInflater = layoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return innerList.size();
    }

    @Override
    public Object getItem(int position) {
        return innerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        if (convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.home_list_detail,null);

            holder.layout1 = (LinearLayout) convertView.findViewById(R.id.list_item01);
            holder.newsImage = (ImageView)convertView.findViewById(R.id.news_image);
            holder.newsAuthor = (TextView)convertView.findViewById(R.id.news_author);
            holder.newsTime = (TextView)convertView.findViewById(R.id.news_time);
            holder.newsTitle = (TextView)convertView.findViewById(R.id.news_title);

            holder.layout2 = (LinearLayout) convertView.findViewById(R.id.list_item02);
            holder.newsImage2 = (ImageView) convertView.findViewById(R.id.news_image02);
            holder.newsTitle2 = (TextView) convertView.findViewById(R.id.news_text02);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if (position % 4 == 0){
            holder.layout1.setVisibility(View.GONE);
            holder.layout2.setVisibility(View.VISIBLE);
            imageLoader.displayImage(innerList.get(position).getThumbnail_pic_s(),holder.newsImage2);
            holder.newsTitle2.setText(innerList.get(position).getTitle());
        }else{
            holder.layout1.setVisibility(View.VISIBLE);
            holder.layout2.setVisibility(View.GONE);
            imageLoader.displayImage(innerList.get(position).getThumbnail_pic_s(),holder.newsImage);
            holder.newsAuthor.setText(innerList.get(position).getAuthor_name());
            holder.newsTime.setText(innerList.get(position).getDate());
            holder.newsTitle.setText(innerList.get(position).getTitle());

        }

        return convertView;
    }

    private class ViewHolder{
        LinearLayout layout1;
        ImageView newsImage;
        TextView newsTitle;
        TextView newsAuthor;
        TextView newsTime;

        LinearLayout layout2;
        ImageView newsImage2;
        TextView newsTitle2;
    }
}
