package com.example.a16245.baseaddapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by 16245 on 2016/04/25.
 */
public class MyAdapter extends BaseAdapter {
    private static final String TAG = "MyAdapter";
    private long count;
    private List<ItemBean> mDate;
    //建立一个LayoutInflater对象
    private LayoutInflater mInflater;


    //在Adapter构造方法里让Context对象= LayoutInflater.from(context)
    public MyAdapter(Context context, List<ItemBean> mDate) {
        this.mDate = mDate;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        if (mDate != null) {
            return mDate.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mDate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long start = System.nanoTime();
        //创建 ViewHolder实例
        ViewHolder viewHolder;
        //用if进行判断
        if (convertView == null) {
            //拿到viewHolder对象
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_main, null);
            //对viewHolder对象里成员变量进行findviewById
            viewHolder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
            viewHolder.tvDesc = (TextView) convertView.findViewById(R.id.tv_desc);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            //将convertView跟viewHolder绑定在一起
            convertView.setTag(viewHolder);
        } else {
            //如果convertView不为空，则用convertView.getTag拿到里面的数据复制给ViewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ;
//        ImageView ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
//        TextView tvDesc = (TextView) convertView.findViewById(R.id.tv_desc);
//        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        ItemBean bean = mDate.get(position);
        //用viewHolder里面的成员变量去set数据
        viewHolder.ivPic.setImageResource(bean.ivPic);
        viewHolder.tvTitle.setText(bean.tvTitle);
        viewHolder.tvDesc.setText(bean.tvDesc);
        long end = System.nanoTime();
        count = end - start;
        Log.d(TAG, "getView: " + count);
        return convertView;
    }

    //创建一个内部类
    public class ViewHolder {
        ImageView ivPic;
        TextView tvDesc;
        TextView tvTitle;

    }


}
