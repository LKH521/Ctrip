package com.bc.lkh.ctrip.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.adapter.NewsAdapter;
import com.bc.lkh.ctrip.adapter.ViewPagerAdapter;
import com.bc.lkh.ctrip.bean.NewsBean;
import com.bc.lkh.ctrip.img.CircularImage;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by 刘凯华 on 2017/9/29.
 */

public class HomeActivity extends Activity implements Toolbar.OnMenuItemClickListener, View.OnClickListener {
    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle mToggle;
    SharedPreferences sh;
    SharedPreferences.Editor ed;
    String phone;
    TextView tv, register, login, music, center, logo;
    Button exit;
    ImageView tou;
    CircularImage imgtou;
    MediaPlayer mediaPlayer;
    ToggleButton toggleButton;
    ViewPager vp;
    ArrayList<ImageView> list;
    ViewPagerAdapter viewPagerAdapter;
    public boolean isStart = true;
    ListView lv_news;
    NewsBean newsBean = null;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        setPermissions();

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        initData();
    }

    private void initView() {
        setContentView(R.layout.main);
        //新闻
        lv_news = findViewById(R.id.lv_news);
        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {//条目点击事件
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, WebViewActivity.class);
                intent.putExtra("url", newsBean.getResult().getData().get(i).getUrl());
                startActivity(intent);
            }
        });
        newsAdapter = new NewsAdapter(HomeActivity.this, newsBean);
        lv_news.setAdapter(newsAdapter);
        //蘑菇推荐时尚新闻
        new Thread() {
            public void run() {
                getData("http://v.juhe.cn/toutiao/index?type=shishang&key=2ca3a5b1cb6edf55250bff550ac34325");
            }
        }.start();
        //标题栏
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setPopupTheme(R.style.PopupOverlay);//设置溢出菜单在标题栏下边
        toolbar.inflateMenu(R.menu.menu_main);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close);
        mediaPlayer = MediaPlayer.create(HomeActivity.this, R.raw.duoxingyun);
        sh = getSharedPreferences("RegisterUser", MODE_PRIVATE);
        ed = sh.edit();
        Intent intent = getIntent();
        tv = (TextView) findViewById(R.id.tv);
        if (intent.getStringExtra("phonee") != null) {
            phone = intent.getStringExtra("phonee").toString();
            tv.setText("亲爱的，" + phone);
        } else {
            tv.setText("请登录");
        }
        toggleButton = findViewById(R.id.myview);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }
            }
        });
        tou = (ImageView) findViewById(R.id.imagetou);
        register = (TextView) findViewById(R.id.tv_zc);
        login = (TextView) findViewById(R.id.tv_dl);
        center = (TextView) findViewById(R.id.tv_grzl);
        logo = (TextView) findViewById(R.id.tv_sctx);
        music = (TextView) findViewById(R.id.tv_music);
        exit = (Button) findViewById(R.id.btn_tcdl);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        center.setOnClickListener(this);
        logo.setOnClickListener(this);
        exit.setOnClickListener(this);
        vp = findViewById(R.id.vpager);
        intDatas();//造数据
        viewPagerAdapter = new ViewPagerAdapter(this, list);
        vp.setAdapter(viewPagerAdapter);
        int m = Integer.MAX_VALUE / 2 % (list.size());
        vp.setCurrentItem(Integer.MAX_VALUE / 2 - m);
//         自动播放 系统睡眠
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (isStart) {
                    while (isStart) {
                        SystemClock.sleep(2000);// 耗时操作
                        // 页面更新必须在主线程中执行，设置下一张，，，，
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                vp.setCurrentItem(vp.getCurrentItem() + 1);
                            }
                        });
                    }
                } else {
                    finish();
                }
            }
        }).start();
    }

    //mToggle
    private void initData() {
        mToggle.syncState();
    }

    //toolbar
    private void initListener() {
        toolbar.setOnMenuItemClickListener(this);
    }

    //Menu
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_friends:
                startActivity(new Intent(HomeActivity.this, Film.class));
                break;
            case R.id.nav_discussion:
                startActivity(new Intent(HomeActivity.this, SelectActivity.class));
                break;
            case R.id.sub_item1:
                startActivity(new Intent(HomeActivity.this, BuyTicket.class));
                break;
            case R.id.sub_item2:
                startActivity(new Intent(HomeActivity.this, Query.class));
                break;
        }
        return false;
    }

    //    抽屉
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_zc://注册
                register();
                break;
            case R.id.tv_dl://登录
                Intent intent = new Intent(HomeActivity.this, Login.class);
                startActivity(intent);
                break;
            case R.id.tv_grzl://个人资料  气泡窗口，显示头像和账号
                popupwindow();
                break;
            case R.id.tv_sctx://上传头像
                String s = tv.getText().toString();
                if (s.equals("请登录")) {
                    Toast.makeText(HomeActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                } else {
                    Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(picture, 110);
                }
                break;
            case R.id.btn_tcdl://退出登录
                Intent i = new Intent(HomeActivity.this, Login.class);
                ed.putBoolean("cbAuto", false);
                ed.commit();
                startActivity(i);
                isStart = false;
//                finish();
                break;
        }
    }

    public void register() {

        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    Intent intent = new Intent(HomeActivity.this, Register.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);

                }
            }
        });
        registerPage.show(HomeActivity.this);
        // 创建EventHandler对象
        EventHandler eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {//数据错误
                    Throwable throwable = (Throwable) data;
                    String msg = throwable.getMessage();
                } else {//数据成功
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {//服务器验证码发送成功
                        Log.d("验证码发送成功", "成功");
                    }
                }
            }
        };
//        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
    }

    public void popupwindow() {
        View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupwindow, null);
//        TextView tvp = contentView.findViewById(R.id.tv_p);
        imgtou = contentView.findViewById(R.id.iv_tou);//头像
        try {
            InputStream is = new FileInputStream(picturePath);
            imgtou.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        if (phone == null) {
//            tvp.setText("请登录");
//        } else {
//            tvp.setText(phone);
//        }
        PopupWindow pop = new PopupWindow(contentView, 200, 200);
        pop.setBackgroundDrawable(new BitmapDrawable());// 设置空白，所有图片都要设成Bitmap位图对象
        pop.setOutsideTouchable(true);// 设置外部点击消失
        pop.showAsDropDown(tv, 200, 0);//设置气泡的位置
    }

    String picturePath = "file:///android_assets/mm.jpg";//图片路径

    @Override//上传头像
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 110 && resultCode == Activity.RESULT_OK && null != intent) {
            Uri selectedImage = intent.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = this.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            picturePath = c.getString(columnIndex);
            Log.d("data", "路径：" + picturePath);
            c.close();
            try {
                InputStream is = new FileInputStream(picturePath);
                tou.setImageBitmap(BitmapFactory.decodeStream(is));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //6.0以后要在代码中动态添加权限
    private void setPermissions() {
        if (ContextCompat.checkSelfPermission(HomeActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 1) {
            if (ContextCompat.checkSelfPermission(HomeActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "写入申请成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "写入申请失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //轮播图片
    private void intDatas() {
        int[] img = new int[]{R.drawable.vpp1, R.drawable.vpp2, R.drawable.vpp3};
        // 把ImageView按顺序放进集合里
        list = new ArrayList<>();

        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(HomeActivity.this);
            iv.setImageResource(img[i]);
//            iv.setBackgroundResource(img[i]);
            list.add(iv);
        }
    }

    //蘑菇推荐时尚新闻
    public void getData(String path) {
        try {
            //NOHTTP 添加依赖 请求数据
            //创建请求对象 设置泛型
            Request<String> request = NoHttp.createStringRequest(path,
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
                    newsBean = gson.fromJson(response.get(), NewsBean.class);
                    Log.d("d", "response.get():" + response.get());
                    runOnUiThread(new Thread() {
                        public void run() {
                            newsAdapter.updateAdapter(newsBean);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
