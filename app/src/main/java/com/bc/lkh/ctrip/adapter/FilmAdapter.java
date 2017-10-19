package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.activity.Film;
import com.bc.lkh.ctrip.bean.FilmBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘凯华 on 2017/9/22.
 */

public class FilmAdapter extends BaseAdapter {
    Context context;
    List<FilmBean.ResultBean> result = new ArrayList<>();
    List<Map<String, String>> list = new ArrayList<>();
    FilmBean bean;


    public FilmAdapter(Context c, FilmBean b) {
        context = c;
       bean=b;
    }

    @Override
    public int getCount() {
        if (bean == null) {
            Log.d("bean", "....." + bean);
            return 0;
        }
        Log.d("result.size()", "....." + result.size());
        return result.size();
    }

    @Override
    public Object getItem(int i) {
        return result.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        TextView name,days,cur,all;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.adapter_film, null);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.days = (TextView) view.findViewById(R.id.days);
            viewHolder.cur = (TextView) view.findViewById(R.id.cur);
            viewHolder.all = (TextView) view.findViewById(R.id.all);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.all.setText(list.get(i).get("all"));
        viewHolder.cur.setText(list.get(i).get("cur"));
        viewHolder.days.setText(list.get(i).get("days"));
        viewHolder.name.setText(list.get(i).get("name"));
        return view;
    }

    public void updateUI(FilmBean filmBean) {
       bean = filmBean;
        result = filmBean.getResult();
//        list.clear();
        for (int i = 0; i < result.size(); i++) {
            Map<String, String> map = new HashMap<>();
            String name = result.get(i).getName();
            map.put("name", name);
            int days = result.get(i).getDays();
            map.put("days", "上映"+days+"天");
            double cur = result.get(i).getCur();
            map.put("cur", "票房："+cur);
            double sum = result.get(i).getSum();
            map.put("all", "总票房"+sum);
            list.add(map);
        }
        notifyDataSetChanged();
        Log.d("data", "刷新" + list.size());
    }
}
