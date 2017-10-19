package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.bean.WeatherForecastBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘凯华 on 2017/8/4.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    Context context;
    List<WeatherForecastBean.ResultBean.FutureBean> future;
    String week, date, dayTime, night, temperature, wind;
    WeatherForecastBean bean;
    List<String> list = new ArrayList<>();
    List<String> li = new ArrayList<>();
    List<String> ld = new ArrayList<>();
    List<String> ln = new ArrayList<>();
    List<String> lw = new ArrayList<>();
    List<String> lt = new ArrayList<>();

    public ExpandAdapter(Context con, WeatherForecastBean b) {// 构造方法
        context = con;
        bean = b;
    }

    public void updateUI(WeatherForecastBean b) {
        bean = b;
        future = bean.getResult().get(0).getFuture();

        for (int i = 0; i < future.size(); i++) {
            week = future.get(i).getWeek();
            li.add(week);
            date = future.get(i).getDate();
            list.add(date);
            dayTime = future.get(i).getDayTime();
            ld.add(dayTime);
            night = future.get(i).getNight();
            ln.add(night);
            temperature = future.get(i).getTemperature();
            lt.add(temperature);
            wind = future.get(i).getWind();
            lw.add(wind);
        }
       notifyDataSetChanged();
;    }

    class ExpandHolder {
        TextView dates, days, nights, tems, winds, weeks;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ExpandHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.group_listview, null);
            holder = new ExpandHolder();
            holder.weeks = view.findViewById(R.id.week);
            view.setTag(holder);
        } else {
            holder = (ExpandHolder) view.getTag();
        }
        holder.weeks.setText(li.get(i));
        Log.d("d","weeks"+li.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ExpandHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.child_listview, null);
            holder = new ExpandHolder();
            holder.dates = view.findViewById(R.id.date);
            holder.days = view.findViewById(R.id.baitian);
            holder.nights = view.findViewById(R.id.yewan);
            holder.tems = view.findViewById(R.id.tem);
            holder.winds = view.findViewById(R.id.wind);
            view.setTag(holder);
        } else {
            holder = (ExpandHolder) view.getTag();
        }
        holder.dates.setText(list.get(i));
        Log.d("d","dates"+list.get(i));
        holder.days.setText(ld.get(i));
        holder.nights.setText(ln.get(i));
        holder.tems.setText(lt.get(i));
        holder.winds.setText(lw.get(i));
        return view;
    }

    @Override
    public int getGroupCount() {
        if (future == null) {
            return 0;
        }
        return future.size();
    }

    @Override
    public int getChildrenCount(int i) {
        if (future == null) {
            return 0;
        }
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
