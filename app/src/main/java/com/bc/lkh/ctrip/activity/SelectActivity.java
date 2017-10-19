package com.bc.lkh.ctrip.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.SelectAdapter;
import com.bc.lkh.ctrip.bean.AirConditionBean;
import com.bc.lkh.ctrip.bean.WeatherForecastBean;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_province, ed_city;
    ListView listView;
    PopupWindow popupWindow;
    ArrayList<String> datas;
    Button bt_check;
    AirCondition airCondition=new AirCondition();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);
        init();
    }

    //初始化控件
    private void init() {
        ImageButton img_dropdown = (ImageButton) findViewById(R.id.img_dropdown);
        img_dropdown.setOnClickListener(this);
        ed_province = (EditText) findViewById(R.id.et_province);
        ed_city = (EditText) findViewById(R.id.ed_city);
        bt_check = (Button) findViewById(R.id.bt_check);
        bt_check.setOnClickListener(this);
    }

    //按钮点击
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_dropdown:
                showPopupWindow();
                break;
            case R.id.bt_check:
                getEditValue();
                break;
        }
    }


    //自定义的下拉框，设置气泡窗口
    private void showPopupWindow() {
        initListView();
        // 显示下拉选择框
        popupWindow = new PopupWindow(listView, ed_province.getWidth(), 300);
        // 设置点击外部区域, 自动隐藏
        popupWindow.setOutsideTouchable(true); // 外部可触摸
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 设置空的背景, 响应点击事件
        popupWindow.setFocusable(true); //设置可获取焦点
        // 显示在指定控件下
        popupWindow.showAsDropDown(ed_province, 0, -5);
    }

    // 初始化要显示的内容
    private void initListView() {
        datas = new ArrayList<>();
        // 创建一些数据,放到集合里
        String[] province = new String[]{
                "北京", "上海", "天津", "重庆", "香港", "澳门", "青海", "新疆", "西藏", "内蒙古", "河北", "河南", "浙江", "安徽", "福建", "江西", "湖南", "山东", "湖北", "广东", "海南", "四川", "贵州", "山西", "云南", "辽宁", "陕西", "吉林", "甘肃", "黑龙江", "江苏"
        };
        for (int i = 0; i < province.length; i++) {
            String s = province[i];
            datas.add(s);
        }
        listView = new ListView(this);
        listView.setDividerHeight(0);
        listView.setBackgroundResource(R.mipmap.listview_background);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("onItemClick: " + i);
                String string = datas.get(i);
                ed_province.setText(string);
                popupWindow.dismiss(); // 消失
            }
        });
        listView.setAdapter(new SelectAdapter(SelectActivity.this, datas));
    }
    String city,province;
    //获取输入框中的省份和城市
    private void getEditValue() {
         city = ed_city.getText().toString();
         province = ed_province.getText().toString();
        Intent intent = new Intent(SelectActivity.this, AirCondition.class);
        intent.putExtra("city", city);
        intent.putExtra("province", province);
        startActivity(intent);
        finish();
    }


}
