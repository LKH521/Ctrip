package com.example.myrecyclerview;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //把引入的选项单菜单以溢出菜单的形式显示到ToolBar上
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //设置recyclerView布局的排列方式
        LinearLayoutManager lin = new LinearLayoutManager(this);
        lin.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(lin);
        //条目数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("我是数据" + i);
        }
        //设置适配器
        myAdapter = new MyAdapter(list, MainActivity.this);
        recyclerView.setAdapter(myAdapter);
        //添加分割线
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //添加动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //通过适配器添加监听  自定义的监听接口
        myAdapter.setOnMyClicklistener(new MyClickListener() {
            @Override
            public void onClick(int position) {
                Snackbar.make(getWindow().getDecorView(), "MyonClick1111" + position, Snackbar.LENGTH_SHORT).show();
            }
            @Override
            public void onLongClick(int position) {
                Snackbar.make(getWindow().getDecorView(), "MyLongonClick2222" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override//创建选项菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override//监听菜单
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list_add:
                myAdapter.addData(3, "4444444444444444");
                break;
            case R.id.list_delete:
                myAdapter.deleteData(3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
