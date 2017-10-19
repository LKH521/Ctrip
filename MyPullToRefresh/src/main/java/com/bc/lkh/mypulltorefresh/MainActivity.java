package com.bc.lkh.mypulltorefresh;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PullToRefreshListView lv;
    ArrayList<String> list = new ArrayList<>();
    MyAdapter adapter;
    ArrayList<String> data = new ArrayList<>();
    int index;
    Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            lv.onRefreshComplete();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //1.查找控件
        lv = (PullToRefreshListView) findViewById(R.id.ptrlv);
        //2.造数据
        //封装全部要显示的数据
        for (int i = 0; i < 100; i++) {
            list.add("我是数据" + (i + 1));
        }
        //获取单次要显示的前5条数据
        for (index = 0; index < 5; index++) {
            data.add(list.get(index));
        }
        //3.创建适配器，设置到ListView上
        adapter = new MyAdapter(this, data);
        lv.setAdapter(adapter);
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
        //5.设置刷新监听，刷新数据
//        如果Mode设置成Mode.BOTH，需要设置刷新Listener为OnRefreshListener2，
//         并实现onPullDownToRefresh()、onPullUpToRefresh()两个方法。
//        如果Mode设置成Mode.PULL_FROM_START或Mode.PULL_FROM_END，需要设置刷新Listener
//          为OnRefreshListener，同时实现onRefresh()方法。
//        当然也可以设置为OnRefreshListener2，但是:Mode.PULL_FROM_START的时候只调用
//         onPullDownToRefresh()方法;Mode.PULL_FROM的时候只调用onPullUpToRefresh()方法.
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //6.下拉数据刷新操作，刷新适配器
                int i;
                int k = 0;
                for (i = index; i < index + 5; i++) {
                    data.add(k, list.get(i));
                    k++;
                }
                index += 20;
                adapter.updateAdapter(data);
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
                //6.上拉数据刷新操作，刷新适配器
                int i;
                int k = 0;
                for (i = index; i < index + 5; i++) {
                    data.add(k, list.get(i));
                    k++;
                }
                index += 20;
                adapter.updateAdapter(data);
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
}
