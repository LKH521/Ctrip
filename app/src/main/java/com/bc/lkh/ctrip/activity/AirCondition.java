package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.bean.AirConditionBean;
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

public class AirCondition extends Activity {
    TextView city, quality, aqi, pm25, pm10, so2, no2, time, tofuture;
    AirConditionBean airConditionBean;
    String getcity, getprovince;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aircondition_fragment);
        init();
    }

    private void init() {
        tofuture = findViewById(R.id.wltq);
        tofuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AirCondition.this, Future.class);
                intent.putExtra("city", getcity);
                intent.putExtra("province", getprovince);
                Log.d("data", "城市和省份" + getcity + "***" + getprovince);
                startActivity(intent);
            }
        });
        city = findViewById(R.id.air_city);
        quality = findViewById(R.id.air_quality);
        aqi = findViewById(R.id.air_aqi);
        pm25 = findViewById(R.id.air_pm2_5);
        pm10 = findViewById(R.id.air_pm10);
        so2 = findViewById(R.id.air_so2);
        no2 = findViewById(R.id.air_no2);
        time = findViewById(R.id.air_time);
        new Thread() {
            public void run() {
                parseAirCondition();
            }
        }.start();
    }

    public void updateUI(AirConditionBean bean) {
        if (bean == null) {
            Toast.makeText(AirCondition.this, "bean为null", Toast.LENGTH_SHORT).show();
        } else if (bean.getResult() == null) {
            Log.d("data", "bean.getResult()==null：：" + bean.getResult());
        } else {
            AirConditionBean.ResultBean resultBean = bean.getResult().get(0);
            String city = resultBean.getDistrict();
            Log.d("city", "city:" + city);
            this.city.setText(city);
            String quality = resultBean.getQuality();
            Log.d("quality", "quality:" + quality);
            this.quality.setText(quality);
            int aqi = resultBean.getAqi();
            this.aqi.setText(aqi + "");
            int pm25 = resultBean.getPm25();
            this.pm25.setText(pm25 + "");
            int pm10 = resultBean.getPm10();
            this.pm10.setText(pm10 + "");
            int so2 = resultBean.getSo2();
            this.so2.setText(so2 + "");
            int no2 = resultBean.getNo2();
            this.no2.setText(no2 + "");
            String updateTime = resultBean.getUpdateTime();
            time.setText(updateTime);
        }
    }


    //解析空气质量
    public void parseAirCondition() {
        try {
            Intent intent = getIntent();
            getcity = intent.getStringExtra("city");
            getprovince = intent.getStringExtra("province");
            String city = URLEncoder.encode(getcity, "UTF-8");
            String province = URLEncoder.encode(getprovince, "UTF-8");
            //NOHTTP 添加依赖 请求数据
            String url = "http://apicloud.mob.com/environment/query?province=" + province + "&key=520520test&city=" + city;
            //创建请求对象 设置泛型
            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.POST);
            request.add("province", city);
            request.add("key", "520520test");
            request.add("city", province);
            Log.d("data", "城市和省份:" + getcity + "000" + getprovince);
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
                    airConditionBean = gson.fromJson(response.get(), AirConditionBean.class);
                    Log.d("d", "获取结果：" + response.get());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateUI(airConditionBean);
                        }
                    });
                }

                @Override
                public void onFailed(int what, Response<String> response) {
                    Log.d("data", "失败" + response);
                }

                @Override
                public void onFinish(int what) {
                    Log.d("data", "完成:" + what);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
