package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.FilmAdapter;
import com.bc.lkh.ctrip.bean.FilmBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.util.ArrayList;

/**
 * Created by 刘凯华 on 2017/10/11.
 */

public class Film extends Activity {
    PullToRefreshListView lv;
    ArrayList<String> li = new ArrayList<>();
    FilmAdapter adapter;
    ArrayList<String> data = new ArrayList<>();
    int index;
    FilmBean filmBean = new FilmBean();
    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x111) {
                lv.onRefreshComplete();
                hand.sendEmptyMessageDelayed(0x112, 500);
            }
            if (msg.what == 0x112) {
                Toast.makeText(Film.this, "下拉刷新成功", Toast.LENGTH_SHORT).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        init();
    }

    private void init() {
        //1.查找控件
        lv = (PullToRefreshListView) findViewById(R.id.pulllv);
        //3.创建适配器，设置到ListView上
        adapter = new FilmAdapter(this, filmBean);
        lv.setAdapter(adapter);
        new Thread() {
            public void run() {
                parseFilmData();
            }
        }.start();
        //4.给刷新的ListView设置属性，下拉或者上滑的提示性文字
        //下拉
        ILoadingLayout proxy = lv.getLoadingLayoutProxy(true, false);
        proxy.setPullLabel("下拉刷新");
        proxy.setRefreshingLabel("正在刷新...");
        proxy.setReleaseLabel("放开刷新");
        //上拉
        ILoadingLayout proxy1 = lv.getLoadingLayoutProxy(false, true);
        proxy1.setPullLabel("上拉刷新");
        proxy1.setRefreshingLabel("正在刷新...");
        proxy1.setReleaseLabel("放开刷新");
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //7.几秒后，隐藏刷新控件，利用Handler机制
                hand.sendEmptyMessageDelayed(0x111, 2000);
                String label = DateUtils.formatDateTime(
                        getApplicationContext(),
                        System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 显示最后更新的时间
                lv.getLoadingLayoutProxy().setLastUpdatedLabel(label);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //7.几秒后，隐藏刷新控件，利用Handler机制
                hand.sendEmptyMessageDelayed(0x111, 2000);
                String label = DateUtils.formatDateTime(
                        getApplicationContext(),
                        System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 显示最后更新的时间
                lv.getLoadingLayoutProxy().setLastUpdatedLabel(label);
            }

        });
    }

    public void updateAdapter(FilmBean b) {
        filmBean = b;
        adapter.updateUI(filmBean);
    }

    //    解析电影数据
    public void parseFilmData() {
        try {
            //NOHTTP 添加依赖 请求数据
            String url = "http://apicloud.mob.com/boxoffice/day/query?area=CN&key=520520test";
            //创建请求对象 设置泛型
            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.POST);
            request.add("area", "CN");
            request.add("key", "520520test");
            request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
            //创建请求队列，添加到队列中
            RequestQueue requestQueue = NoHttp.newRequestQueue();
            requestQueue.add(0, request, new OnResponseListener<String>() {
                @Override
                public void onStart(int what) {

                }

                @Override
                public void onSucceed(int what, Response<String> response) {
                    Log.d("data", "response:" + response.get());
                    Gson gson = new Gson();
                    filmBean = gson.fromJson(response.get(), FilmBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("data", "联网结束");
                            updateAdapter(filmBean);
                        }
                    });
                }

                @Override
                public void onFailed(int what, Response<String> response) {

                }

                @Override
                public void onFinish(int what) {
                    Log.d("data", "2");
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
