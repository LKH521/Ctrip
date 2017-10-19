package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.bc.lkh.ctrip.R;

import java.util.ArrayList;

/**
 * Created by 刘凯华 on 2017/8/1.
 */

public class SelectAdapter extends BaseAdapter {
    ArrayList<String> arrayList;
    Context context;
    PopupWindow popupWindow;

    public SelectAdapter(Context c, ArrayList<String> list) {
        arrayList = list;
        context = c;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = View.inflate(parent.getContext(), R.layout.select_adapter, null);
        } else {
            view = convertView;
        }
        TextView tv_number = (TextView) view.findViewById(R.id.tv_select);
        tv_number.setText(arrayList.get(position));
        return view;
    }
}
