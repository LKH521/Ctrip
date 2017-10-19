package com.bc.lkh.ctrip.activity;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.widget.ExpandableListView;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.ExpandAdapter;
import com.bc.lkh.ctrip.bean.WeatherForecastBean;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by 刘凯华 on 2017/8/3.
 */

public class Future extends Activity {
    ExpandableListView el;
    ExpandAdapter adapter;
    WeatherForecastBean weatherForecastBean = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.future_fragment);
        el = findViewById(R.id.el);
//        adapter = new ExpandAdapter(Future.this, weatherForecastBean);
//        el.setAdapter(adapter);
        new Thread() {
            public void run() {
                Log.d("d", "parseWeatherForecast");
                parseWeatherForecast();
            }
        }.start();
        adapter = new ExpandAdapter(Future.this, weatherForecastBean);
        el.setAdapter(adapter);
    }

    //解析天气预报
    public void parseWeatherForecast() {
        Intent intent = getIntent();
        String getcity = intent.getStringExtra("city");
        String getprovince = intent.getStringExtra("province");
        Log.d("d", "ddddddddddddd:" + getcity + "," + getprovince);
        try {
            String city = URLEncoder.encode(getcity, "UTF-8");
            String province = URLEncoder.encode(getprovince, "UTF-8");
            String url =
                    "http://apicloud.mob.com/v1/weather/query?province=" + province + "&key=520520test&city=" + city;
            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.POST);
            request.add("province", province);
            request.add("key", "520520test");
            request.add("city", city);
            request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
            //创建请求队列，添加到队列中
            RequestQueue requestQueue = NoHttp.newRequestQueue();
            requestQueue.add(0, request, new OnResponseListener<String>() {
                @Override
                public void onStart(int what) {

                }

                @Override
                public void onSucceed(int what, Response<String> response) {
                    Gson gson = new Gson();
                    weatherForecastBean = gson.fromJson(response.get(), WeatherForecastBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("d", "获取结果：" + weatherForecastBean.getResult().get(0).getCity());
                            adapter.updateUI(weatherForecastBean);
                        }
                    });
                }

                @Override
                public void onFailed(int what, Response<String> response) {
                    Log.d("d", "获取结果：" + weatherForecastBean.getResult().get(0).getCity());
                }

                @Override
                public void onFinish(int what) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
