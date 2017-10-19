package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.view.PagerAdapter;

import com.bc.lkh.ctrip.R;

import java.util.ArrayList;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by 刘凯华 on 2017/9/4.
 */

public class ViewPagerActivity extends Activity {
    ImageButton register, login, next;
    ViewPager vp;
    ArrayList<ImageView> arrayList = new ArrayList<>();
    EventHandler eventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        init();
    }

    public void register() {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果,注册成功后跳转
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    Intent intent = new Intent(ViewPagerActivity.this, Register.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                    finish();
                }
            }
        });
        registerPage.show(ViewPagerActivity.this);
        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {//数据错误
                    Throwable throwable = (Throwable) data;
                    String msg = throwable.getMessage();
                    Toast.makeText(ViewPagerActivity.this, msg, Toast.LENGTH_SHORT).show();
                } else {//数据成功
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {//服务器验证码发送成功
                        Log.d("验证码发送成功", "成功");
                    }
                }
            }
        };
        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
    }

    private void init() {
        //1.查找控件
        vp = findViewById(R.id.vp);
        register = findViewById(R.id.ib_register);
        login = findViewById(R.id.ib_login);
        next = findViewById(R.id.ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),
                        HomeActivity.class));
                finish();
            }
        });
        //2.将图片存放在数组里，创建图片控件，通过循环添加到集合里，根据集合设置适配器
        int[] img = {R.drawable.v1, R.drawable.v2, R.drawable.v3};
        for (int i = 0; i < img.length; i++) {
            ImageView imageView = new ImageView(ViewPagerActivity.this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//适应图片原本的宽高
            imageView.setImageResource(img[i]);
            arrayList.add(imageView);
        }
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(arrayList.get(position));
                return arrayList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(arrayList.get(position));
            }
        });
        //3.vp设置图片改变监听，最后一页显示按钮
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == arrayList.size() - 1) {// 脚标是最后一张
                    register.setVisibility(View.VISIBLE);
                    login.setVisibility(View.VISIBLE);
                    register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            register();
                        }
                    });
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getApplicationContext(),
                                    Login.class));
                            finish();
                        }
                    });
                } else {
                    register.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }
}


