package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.CodeAdapter;
import com.bc.lkh.ctrip.bean.Code;
import com.bc.lkh.ctrip.interfaces.MyClickListener;
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
 * Created by 刘凯华 on 2017/8/28.
 */

public class Query extends Activity {

    ByteArrayOutputStream bs;
    Code code;
    TextView at, starts, tcode, ends, counts;
    CodeAdapter codeadapter;
    RecyclerView recyclerView;
    boolean count = true;
    int iii;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query);
        init();
    }

    public void init() {
        //1.自动补全框
        final AutoCompleteTextView auto = findViewById(R.id.auto);
        //数组适配器，只能展示字符串
        String[] cod = new String[]{"K7761", "K219", "K7725", "K599", "K7705", "K269", "K819", "G501", "G529", "G71", "G309", "G101",
                "G139", "G3", "G43", "T145", "T109", "T297", "T47",
                "Z149", "Z157", "Z203", "Y511", "D313", "D311", "D321", "D101",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Query.this, android.R.layout.simple_list_item_1, android.R.id.text1, cod);
        auto.setAdapter(adapter);
        //2.查找控件，设置数据
        recyclerView = findViewById(R.id.lv_QUERY);
        //设置recyclerView布局的排列方式
        LinearLayoutManager lin = new LinearLayoutManager(this);
        lin.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(lin);
        at = findViewById(R.id.startt);//到达时间
        starts = findViewById(R.id.start);//起始站
        ends = findViewById(R.id.end);//末站
        tcode = findViewById(R.id.car);//车次
        counts = findViewById(R.id.count);//历经几站
        code = null;
        codeadapter = new CodeAdapter(Query.this, code);
        recyclerView.setAdapter(codeadapter);
        //添加分割线
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //添加动画

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //通过适配器添加监听  自定义的监听接口
        codeadapter.setOnMyClicklistener(new MyClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("data", "position::::***" + position);
//                Snackbar.make(getWindow().getDecorView(),  position, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Log.d("data", "position:::::" + position);
                iii = position;
                //弹框，是否删除
                final AlertDialog.Builder builder = new AlertDialog.Builder(Query.this);
                builder.setTitle("删除条目：");

                builder.setMessage("确定删除该条内容吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        codeadapter.deleteData(iii);//删除
                    }
                }).show();
//                Snackbar.make(getWindow().getDecorView(), "MyLongonClick2222" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        //3.搜索按钮
        ImageView search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String at = auto.getText().toString().trim();
                //解析数据
                new Thread() {
                    public void run() {
                        parseCtripTravelCodeData(at);
                    }
                }.start();
            }
        });
        counts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count) {
                    //4.ListView的数据展示
                    recyclerView.setVisibility(View.VISIBLE);
                    count = false;
                } else {
                    recyclerView.setVisibility(View.INVISIBLE);
                    count = true;
                }
            }
        });

    }

    public void updateAdapter(Code c) {
        code = c;
        if (!code.getRetCode().equals("23201")) {
            int size = code.getResult().size();
            counts.setText("历经：" + size + "站");
            Code.ResultBean resultBean = code.getResult().get(0);
            String startTime = resultBean.getStartTime();
            at.setText(startTime);
            String startStationName = resultBean.getStartStationName();
            starts.setText(startStationName);
            String endStationName = resultBean.getEndStationName();
            ends.setText(endStationName);
            String stationTrainCode = resultBean.getStationTrainCode();
            tcode.setText(stationTrainCode);
            codeadapter.updateUI(code);
        } else {
            Toast.makeText(Query.this, "抱歉！暂时没有查找到相关信息", Toast.LENGTH_LONG).show();
        }
    }

    public void parseCtripTravelCodeData(String c) {
        try {
            String cd = URLEncoder.encode(c, "UTF-8");
            //NOHTTP 添加依赖 请求数据
            String url = "http://apicloud.mob.com/train/tickets/queryByTrainNo?trainno=" + cd + "&key=520520test";
            //创建请求对象 设置泛型
            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.POST);
            request.add("trainno", cd);
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
                    code = gson.fromJson(response.get(), Code.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("data", "联网结束");
                            updateAdapter(code);
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
