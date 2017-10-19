package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.bean.Travel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘凯华 on 2017/9/1.
 */

public class TicketAdapter extends BaseAdapter {
    Context context;
    List<Travel.ResultBean> result = new ArrayList<>();
    List<Map<String, String>> list = new ArrayList<>();

    Travel bean;


    public TicketAdapter(Context c, Travel b) {
        context = c;
        bean = b;
    }

    @Override
    public int getCount() {
        if (bean == null) {
            Log.d("bean", "....." + bean);
            return 0;
        }
//        Log.d("result.size()", "....." + result.size());
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(viewGroup.getContext(), R.layout.buy_adapter, null);
            holder.start = view.findViewById(R.id.start);
            holder.st = view.findViewById(R.id.startt);
            holder.et = view.findViewById(R.id.endt);
            holder.end = view.findViewById(R.id.end);
            holder.lishi = view.findViewById(R.id.lishi);
            holder.checi = view.findViewById(R.id.car);
            holder.yw = view.findViewById(R.id.yw);
            holder.yz = view.findViewById(R.id.yz);
            holder.wz = view.findViewById(R.id.wz);
            holder.rw = view.findViewById(R.id.rw);
            holder.ydz = view.findViewById(R.id.ydz);
            holder.edz = view.findViewById(R.id.edz);
            holder.swz = view.findViewById(R.id.swz);
            holder.tdz = view.findViewById(R.id.tdz);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.start.setText(list.get(i).get("start"));
        holder.st.setText(list.get(i).get("st"));
        holder.et.setText(list.get(i).get("et"));
        holder.end.setText(list.get(i).get("end"));
        holder.lishi.setText(list.get(i).get("lishi"));
        holder.checi.setText(list.get(i).get("checi"));
        if (list.get(i).get("yw") == null) {
            holder.yw.setText("硬卧：暂无");
        } else {
            holder.yw.setText("硬卧：" + list.get(i).get("yw"));
        }
        if (list.get(i).get("yz") == null) {
            holder.yz.setText("硬座：暂无");
        } else {
            holder.yz.setText("硬座：" + list.get(i).get("yz"));
        }
        if (list.get(i).get("wz") == null) {
            holder.wz.setText("无座：暂无");
        } else {
            holder.wz.setText("无座：" + list.get(i).get("wz"));
        }
        if (list.get(i).get("rw") == null) {
            holder.rw.setText("软卧：暂无");
        } else {
            holder.rw.setText("软卧：" + list.get(i).get("rw"));
        }
        if (list.get(i).get("yd") == null) {
            holder.ydz.setText("一等座：暂无");
        } else {
            holder.ydz.setText("一等座：" + list.get(i).get("yd"));
        }
        if (list.get(i).get("ed") == null) {
            holder.edz.setText("二等座：暂无");
        } else {
            holder.edz.setText("二等座：" + list.get(i).get("ed"));
        }
        if (list.get(i).get("sw") == null) {
            holder.swz.setText("商务座：暂无");
        } else {
            holder.swz.setText("商务座：" + list.get(i).get("sw"));
        }
        if (list.get(i).get("td") == null) {
            holder.tdz.setText("特等座：暂无");
        } else {
            holder.tdz.setText("特等座：" + list.get(i).get("td"));
        }
        return view;
    }

    class ViewHolder {
        TextView start, st, end, et, lishi, checi, yw, yz, rw, wz, ydz, edz, swz, tdz;
    }

    public void updateUI(Travel b) {
        bean = b;//进入后赋值，让它不为空
        result = b.getResult();
        list.clear();
        for (int i = 0; i < result.size(); i++) {
            Map<String, String> map = new HashMap<>();
            String endStationName = result.get(i).getEndStationName();
            map.put("end", endStationName);
            String arriveTime = result.get(i).getArriveTime();
            map.put("et", arriveTime);
            String lishi = result.get(i).getLishi();
            map.put("lishi", lishi);
            String startStationName = result.get(i).getStartStationName();
            map.put("start", startStationName);
            String startTime = result.get(i).getStartTime();
            map.put("st", startTime);
            String trainClassName = result.get(i).getStationTrainCode();
            map.put("checi", trainClassName);
            String pricerw = result.get(i).getPricerw();
            map.put("rw", pricerw);
            String priceyw = result.get(i).getPriceyw();
            map.put("yw", priceyw);
            String pricewz = result.get(i).getPricewz();
            map.put("wz", pricewz);
            String priceyz = result.get(i).getPriceyz();
            map.put("yz", priceyz);
            String priceyd = result.get(i).getPriceyd();
            map.put("yd", priceyd);
            String priceed = result.get(i).getPriceed();
            map.put("ed", priceed);
            String pricesw = result.get(i).getPricesw();
            map.put("sw", pricesw);
            String pricetd = result.get(i).getPricetd();
            map.put("td", pricetd);
            list.add(map);
        }
        notifyDataSetChanged();//刷新适配器
        Log.d("data", "刷新" + list.size());
    }
}
