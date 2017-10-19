package com.bc.lkh.lkh_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bc.lkh.lkh_test.adapter.NewsAdapter;
import com.bc.lkh.lkh_test.bean.NewsBean;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    NewsBean newsbean = null;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        lv = (ListView) findViewById(R.id.listv);
        newsAdapter = new NewsAdapter(MainActivity.this, newsbean);
        lv.setAdapter(newsAdapter);
        new Thread() {
            @Override
            public void run() {
                super.run();
                parseNewsData("http://v.juhe.cn/toutiao/index?type=shishang&key=2ca3a5b1cb6edf55250bff550ac34325");
            }
        }.start();
    }

    public void parseNewsData(String url) {
        //NOHTTP 添加依赖 请求数据
        //创建请求对象 设置泛型
        Request<String> request = NoHttp.createStringRequest(url,
                RequestMethod.POST);
        request.add("type", "shishang");
        request.add("key", "2ca3a5b1cb6edf55250bff550ac34325");
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
                newsbean = gson.fromJson(response.get(), NewsBean.class);
                runOnUiThread(new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        newsAdapter.updateAdapter(newsbean);
                    }
                });
            }

            @Override
            public void onFailed(int what, Response<String> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
    }
}
