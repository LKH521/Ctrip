package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.TicketAdapter;
import com.bc.lkh.ctrip.bean.Travel;
import com.bc.lkh.ctrip.listview.MyListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by 刘凯华 on 2017/8/28.
 */
@ContentView(R.layout.buytictek)
public class BuyTicket extends Activity {

    EditText start, end;
    Button query;
    ListView lv;
    ScrollView sv;
    Travel travel = new Travel();
    TicketAdapter ticketAdapter;
    ByteArrayOutputStream bs;
    ImageView img;
    Callback.Cancelable cancelable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.buytictek);
        x.view().inject(this);
        init();
    }


    private void init() {
        lv = findViewById(R.id.lv);
        sv = findViewById(R.id.scroll);

        ticketAdapter = new TicketAdapter(BuyTicket.this, travel);
        lv.setAdapter(ticketAdapter);
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lv.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    lv.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                playSingleChoiceDialog();
            }
        });
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        img = findViewById(R.id.iv_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = start.getText().toString();
                String e = end.getText().toString();
                if (s.length() > 0 && e.length() > 0) {
                    end.setText(s);
                    start.setText(e);
                } else {
                    Toast.makeText(BuyTicket.this, "请将起始站和终点站填写完整！", Toast.LENGTH_LONG).show();
                }
            }
        });
        query = findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s = start.getText().toString();
                final String e = end.getText().toString();
                if (TextUtils.isEmpty(s) || TextUtils.isEmpty(e)) {//输入框为空
                    Toast.makeText(BuyTicket.this, "输入框不能为空", Toast.LENGTH_LONG).show();
                } else {//不为空
                    new Thread() {
                        public void run() {
                            parseCtripTravelData(s, e);
                        }
                    }.start();
                }
            }
        });
    }

    // 弹出单选框
    private void playSingleChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(BuyTicket.this);
        final String[] items = new String[]{"成人票", "学生票", "儿童票", "残军票"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = items[which];
                Toast.makeText(BuyTicket.this, name, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void updateAdapter(Travel b) {
        travel = b;
        start.setText(travel.getResult().get(0).getStartStationName());
        end.setText(travel.getResult().get(0).getEndStationName());
        ticketAdapter.updateUI(travel);
    }

    public void parseCtripTravelData(String s, String e) {
        try {
            //xUtils 添加依赖 请求数据
            String start = URLEncoder.encode(s, "UTF-8");
            String end = URLEncoder.encode(e, "UTF-8");
            String url = "http://apicloud.mob.com/train/tickets/queryByStationToStation?start=" + start + "&end=" + end + "&key=520520test";
            RequestParams params = new RequestParams(url);
            params.addQueryStringParameter("start", start);
            params.addQueryStringParameter("end", end);
            cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.d("data", result);
                    Log.d("data", "1");
                    Gson gson = new Gson();
                    travel = gson.fromJson(result, Travel.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateAdapter(travel);
                        }
                    });

                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {
                    Log.d("data", "2");
                }
            });
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
    }

}
