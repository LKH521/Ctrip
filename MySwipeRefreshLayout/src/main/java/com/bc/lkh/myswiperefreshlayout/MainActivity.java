package com.bc.lkh.myswiperefreshlayout;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    SwipeRefreshLayout sp;
    MyAdapter adapter;
    int index;
    ArrayList<String> allData = new ArrayList<>();
    ArrayList<String> partData = new ArrayList<>();
    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x111) {
                adapter.updateAdapter(partData);
                sp.setRefreshing(false);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        sp = (SwipeRefreshLayout) findViewById(R.id.sp);
        lv = (ListView) findViewById(R.id.lv);
        //设置刷新控件的颜色变化
        sp.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright, null),
                getResources().getColor(android.R.color.holo_green_dark, null),
                getResources().getColor(android.R.color.holo_red_light, null),
                getResources().getColor(android.R.color.holo_orange_dark, null));
        //设置刷新控件的背景颜色
        sp.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.colorAccent, null));
        //监听
        sp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "正在刷新...", Toast.LENGTH_SHORT).show();
                hand.sendEmptyMessageDelayed(0X111, 3000);
                //将新数据插入到集合的前面 显示到ListView的上方
                int i;
                int k = 0;
                for (i = index; i < index + 20; i++) {
                    partData.add(k, allData.get(i));
                    k++;
                }
                index += 20;
            }
        });
        lv = (ListView) findViewById(R.id.lv);
        //封装全部要显示的数据
        for (int i = 0; i < 100; i++) {
            allData.add("我是数据" + i);
        }
        //获取单次要显示的前20条数据
        for (index = 0; index < 20; index++) {
            partData.add(allData.get(index));
        }
        adapter = new MyAdapter(MainActivity.this, partData);
        lv.setAdapter(adapter);
    }
}
