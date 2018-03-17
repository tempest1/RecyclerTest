package com.kkrs.recyclertest;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zd on 2018/3/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> implements View.OnClickListener{
    private OnItemClickListener itemClickListener = null;
    private Context context;
    private List<String>  list = new ArrayList<>();

    //设置数据
    public void setData(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }

    //OnCreateViewHolder用来给rv创建缓存的
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //参数3：判断条件 true  1.是打气 2.添加到parent
        View view = LayoutInflater.from(context).inflate(R.layout.main_recyclerview_item, parent, false);
        MyAdapter.MyHolder holder = new MyAdapter.MyHolder(view);

        //为每一个item绑定监听
        view.setOnClickListener(this);
        return holder;
    }

    //给缓存控件设置数据
    public void onBindViewHolder(MyAdapter.MyHolder holder, int position) {
        String item = list.get(position);
        holder.textView.setText(item);
        holder.icon.setImageResource(R.mipmap.ic_launcher);
        holder.itemView.setTag(position);
    }

    //获取记录数
    public int getItemCount() {
        return list.size();
    }

    //初始化样式
    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView textView;

        //实现的方法
        public MyHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.item_iv_icon);
            textView = (TextView) itemView.findViewById(R.id.item_tv_title);
        }
    }

    //点击事件设置
    @Override
    public void onClick(View view) {
        if(itemClickListener!=null){
            itemClickListener.onItemClick((Integer) view.getTag());
        }
    }

    //接口设置
    public void setItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }


    //自定义点击接口
    public  interface OnItemClickListener {
        void onItemClick(int tag);
    }
}
