package com.bc.lkh.myswiperefreshlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 刘凯华 on 2017/9/21.
 */

public class MyAdapter extends BaseAdapter {
   Context context;
    ArrayList<String> list;

    public MyAdapter(Context context,ArrayList<String> list){
       this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
//ListView监听有四个参数：适配器  view  int本身位置ID是连续的  long数据库自增长的主键ID
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tv=new TextView(context);
//        tv.setTextColor(android.R.color.holo_purple);
        tv.setTextColor(context.getResources().getColor(android.R.color.holo_purple,null));
        tv.setTextSize(35);
        tv.setText(list.get(i));
        return tv;
    }

    public void updateAdapter(ArrayList<String> li){
        list=li;
        notifyDataSetChanged();
    }
}
