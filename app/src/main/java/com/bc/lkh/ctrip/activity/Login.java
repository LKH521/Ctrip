package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.bean.User;
import com.bc.lkh.ctrip.dao.UserDao;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by 刘凯华 on 2017/9/4.
 */

public class Login extends Activity {
    UserDao dao;
    User user;
    EditText phone, pass;
    String ph, pwd;
    CheckBox cbCount, cbAuto;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        sharedPreferences = getSharedPreferences("RegisterUser", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        init();
        restoreUIbySharedPreferences();
    }

    private void init() {
        dao = new UserDao(Login.this);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//返回
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        phone = findViewById(R.id.login_phone);
        pass = findViewById(R.id.login_pass);
        Intent data = getIntent();
        phone.setText(data.getStringExtra("phone"));
        pass.setText(data.getStringExtra("pass"));
        cbCount = findViewById(R.id.cb_count);
        cbAuto = findViewById(R.id.cb_auto);
        Button login = findViewById(R.id.btn_login);
        Button toregister = findViewById(R.id.btn_tozc);//去注册
        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {//登录按钮
            @Override
            public void onClick(View view) {
                //获取输入框的值
                ph = phone.getText().toString().trim();
                pwd = pass.getText().toString().trim();
                //输入框不为空
                if (TextUtils.isEmpty(ph) || TextUtils.isEmpty(pwd)) { // 判断是否为空
                    Toast.makeText(getApplicationContext(), "手机号或密码不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //查询数据库的信息，是否存在和正确
                    user = dao.queryUserByPhone(ph);
                    if (user == null) {// 判断账号是否存在
                        Toast.makeText(getApplicationContext(), "账号不存在",
                                Toast.LENGTH_SHORT).show();
                    } else if (user.getPassword().equals(pwd)) {// 判断账号密码是否一致
                        judgeCheckBoxIsChecked();
                        // 账号存在 登录成功
                        Intent intent = new Intent(Login.this,
                                HomeActivity.class);
                        String userPhone = user.getPhone();
                        intent.putExtra("phonee", userPhone);
                        startActivity(intent);
                        finish();
                    } else {// 账号密码不一致
                        Toast.makeText(getApplicationContext(), "密码有误！",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                cbCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b == false) {
                            cbAuto.setChecked(false);
                        }
                    }
                });
                cbAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            cbCount.setChecked(true);//通过代码  设置复选框  为 选中状态
                        }
                    }
                });
            }
        });
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
                    Intent intent = new Intent(Login.this, Register.class);
                    intent.putExtra("phone", phone);
//                    startActivity(intent);
                    //带有返回值的跳转
                    startActivityForResult(intent, 100);
//                    finish();
                }
            }
        });
        registerPage.show(Login.this);
        // 创建EventHandler对象
        EventHandler eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {//数据错误
                    Throwable throwable = (Throwable) data;
                    String msg = throwable.getMessage();
//                    Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();
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

    //接收返回的消息
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //验证请求码和返回码
        if (requestCode == 100 && resultCode == 101) {
            //接收返回的信息
            String count = data.getStringExtra("phone");
            String psw = data.getStringExtra("pass");
            phone.setText(count);
            pass.setText(psw);
        }
    }

    //保存账号
    void judgeCheckBoxIsChecked() {
        //根据逻辑上的优先级  先判断自动登陆的复选框 再判断保存账号
        if (cbAuto.isChecked()) {
            editor.putString("count", ph);
            editor.putString("psw", pwd);
            editor.putBoolean("cbCount", true);
            editor.putBoolean("cbAuto", true);
            editor.commit();
        } else if (cbCount.isChecked()) {
            editor.putString("count", ph);
            editor.putString("psw", pwd);
            editor.putBoolean("cbCount", true);
            editor.putBoolean("cbAuto", false);
            editor.commit();
        }
    }

    ProgressDialog pg;

    //自动登录
    void restoreUIbySharedPreferences() {
        if (sharedPreferences.getBoolean("cbAuto", false)) {
            phone.setText(sharedPreferences.getString("count", ""));
            pass.setText(sharedPreferences.getString("psw", ""));
            cbCount.setChecked(true);
            cbAuto.setChecked(true);
            pg = ProgressDialog.show(Login.this, "自动登录中...", null);
            pg.setCanceledOnTouchOutside(false);
            new Thread() {
                public void run() {
                    try {
                        sleep(5000);
                        runOnUiThread(new Thread() {
                            public void run() {
                                pg.dismiss();
                                ph = phone.getText().toString().trim();
                                // 账号存在 登录成功
                                Intent intent = new Intent(Login.this,
                                        HomeActivity.class);
                                intent.putExtra("phonee", ph);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } else if (sharedPreferences.getBoolean("cbCount", false)) {
            phone.setText(sharedPreferences.getString("count", ""));
            pass.setText(sharedPreferences.getString("psw", ""));
            cbCount.setChecked(true);
        }
    }
}
