package com.example.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wangye on 2017/9/20.
 */
//外部适配器，需要继承自己的RecyclerView.Adapter<MyAdapter.MyHolder>
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    List<String> list;
    Context c;
    MyClickListener my;

    public MyAdapter(List<String> list, Context c) {
        this.list = list;
        this.c = c;
    }

    //自定义ViewHolder  需要继承RecyclerView.ViewHolder
    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tx;
        View v;

        public MyHolder(View itemView) {
            super(itemView);
            v = itemView;
            tx = itemView.findViewById(R.id.textView);
        }
    }

    //获取监听对象
    void setOnMyClicklistener(MyClickListener my) {
        this.my = my;
    }

    //添加数据
    public void addData(int position, String data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    //删除数据
    public void deleteData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override//创建视图
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(c, R.layout.adapter, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override//绑定视图  给视图添加属性（设置内容 添加监听等）
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tx.setText(list.get(position));
        holder.v.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//        Toast.makeText(c, "onClick", Toast.LENGTH_SHORT).show();
                my.onClick(position);
            }
        });
        holder.v.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                my.onLongClick(position);
//        Toast.makeText(c, "onLongClick", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override//获取数量
    public int getItemCount() {
        return list.size();
    }
}
