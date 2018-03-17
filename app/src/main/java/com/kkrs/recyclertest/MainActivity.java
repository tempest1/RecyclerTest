package com.kkrs.recyclertest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity  {

    //申明变量
    private RecyclerView rv;
    Context context;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        //
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(context));

        //填充数据
        list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("测试记录" + i);
        }

        //设置Adapter
        MyAdapter adapter = new MyAdapter();
        adapter.setData(context,list);
        rv.setAdapter(adapter);

        //设置点击事件
        adapter.setItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int tag) {
                Toast.makeText(MainActivity.this, ""+tag, Toast.LENGTH_SHORT).show();
            }
        });

    }



}
