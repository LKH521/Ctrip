package com.bc.lkh.liukaihua_test.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bc.lkh.liukaihua_test.R;
import com.bc.lkh.liukaihua_test.adapter.NewsAdapter;
import com.bc.lkh.liukaihua_test.bean.NewsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 刘凯华 on 2017/9/11.
 */

public class NewsFragment extends Fragment {
    public NewsAdapter adapter = null;
    public ListView listView;
    public NewsBean newsBean;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.newsfragment,null);
        listView = view.findViewById(R.id.lv);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(),WebViewActivity.class);
//                intent.putExtra("url",
//                        ((NewsBean.ResultBean.DataBean)adapterView.getItemAtPosition(i)).getUrl());
//                startActivity(intent);
//                ((NewsBean.ResultBean.DataBean)adapterView.getItemAtPosition(i)).setClick(true);
//                //当前修改的数据源直接是从ListView显示的数据获取的 不需要传入外面的新数据  所以直接
//                //调用notifyDataSetChanged就可以了
//                adapter.notifyDataSetChanged();
//            }
//        });
        getDataByType("");
        return view;
    }

    public void getDataByType(final String type) {
        new Thread(){
            public void run(){
                try {
//                    http://v.juhe.cn/toutiao/index?type=top&key=562402375cb93590c7eec9ade024dffe
                    URL url = new URL("http://v.juhe.cn/toutiao/index?"
                            + "type=" + type + "&key=2ca3a5b1cb6edf55250bff550ac34325");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setConnectTimeout(10000);
                    con.setReadTimeout(10000);
                    con.connect();

                    if (con.getResponseCode() == 200) {
                        InputStream is = con.getInputStream();
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        byte[] buffer = new byte[512];
                        int length;
                        while ((length = is.read(buffer)) != -1) {
                            bs.write(buffer, 0, length);
                            bs.flush();
                        }
                        newsBean = new Gson().fromJson(bs.toString(), new TypeToken<NewsBean>() {
                        }.getType());

                        getActivity().runOnUiThread(new Thread() {
                            public void run() {
                                if(adapter == null){
                                    adapter = new NewsAdapter(getActivity(), newsBean);
                                    listView.setAdapter(adapter);
                                }else{
                                    adapter.updateAdapter(newsBean);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
