package com.bc.lkh.mypulltorefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 刘凯华 on 2017/9/22.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> list;


    public MyAdapter(Context c, ArrayList<String> l) {
        context = c;
        list = l;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        TextView tv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.adapter_listview, null);
            viewHolder.tv = (TextView) view.findViewById(R.id.adapter_tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(list.get(i));
        return view;
    }

    public void updateAdapter(ArrayList<String> arrayList) {
        this.list = arrayList;
        notifyDataSetChanged();
    }
}
