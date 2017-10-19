package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.activity.Query;
import com.bc.lkh.ctrip.bean.Code;
import com.bc.lkh.ctrip.interfaces.MyClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘凯华 on 2017/9/5.
 */

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.MyHolder> {
    Code code;
    Context context;
    List<Code.ResultBean> result = new ArrayList<>();
    List<Map<String, Object>> list = new ArrayList<>();
    MyClickListener my;
    public CodeAdapter(Context c, Code code) {
        context = c;
        this.code = code;
    }

    //自定义ViewHolder  需要继承RecyclerView.ViewHolder
    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView startime, pausetime, station;
        View v;

        public MyHolder(View itemView) {
            super(itemView);
            v = itemView;
            station = itemView.findViewById(R.id.station);
            startime = itemView.findViewById(R.id.at);
            pausetime = itemView.findViewById(R.id.st);
        }
    }

    //获取监听对象
    public void setOnMyClicklistener(MyClickListener my) {
        this.my = my;
    }

    //    //添加数据
//    public void addData(int position, String data) {
//        list.add(position, data);
//        notifyItemInserted(position);
//    }
//
    //删除数据
    public void deleteData(int position) {
        Log.d("data", "position:" + position);
        list.remove(position);
        notifyItem(list);
    }

    void notifyItem(List<Map<String, Object>> lists) {
        list = lists;
        notifyDataSetChanged();
    }

    @Override//创建视图
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("data", "viewType:" + viewType);
        Log.d("data", "viewType:" + parent.getId());

        View view = View.inflate(context, R.layout.query_adapter, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override//绑定视图  给视图添加属性（设置内容 添加监听等）
    public void onBindViewHolder(MyHolder holder, final int i) {
        holder.station.setText(list.get(i).get("station").toString());
        holder.startime.setText(list.get(i).get("at").toString());
        holder.pausetime.setText("停留时间：" + list.get(i).get("st"));
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my.onClick(i);
            }
        });
        holder.v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                my.onLongClick(i);
                return false;
            }
        });
    }


    @Override//获取数量
    public int getItemCount() {
        if (code == null) {
            return 0;
        }
        return list.size();
    }

    public void updateUI(Code c) {
        code = c;
        list.clear();
        result = code.getResult();
        for (int i = 0; i < result.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            String stationName = result.get(i).getStationName();
            map.put("undex", i);
            map.put("station", stationName);
            String arriveTime = result.get(i).getArriveTime();
            map.put("at", arriveTime);
            String stopoverTime = result.get(i).getStopoverTime();
            map.put("st", stopoverTime);
            list.add(map);

        }
        Query query = new Query();
        notifyDataSetChanged();//刷新适配器
        Log.d("data", "刷新" + list.size());
    }
}
