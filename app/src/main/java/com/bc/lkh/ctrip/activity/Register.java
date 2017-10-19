package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bc.lkh.ctrip.R;
import com.bc.lkh.ctrip.dao.UserDao;

/**
 * Created by 刘凯华 on 2017/9/4.
 */

public class Register extends Activity {
    EditText pass, pass2;
    String phone;
    private SharedPreferences sh;
    private SharedPreferences.Editor ed;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }

    private void init() {
        sh = getSharedPreferences("RegisterUser", MODE_PRIVATE);
        ed = sh.edit();
        //获取手机号
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        Toast.makeText(Register.this, "phone:" + phone, Toast.LENGTH_SHORT).show();
        //当点击注册时获取密码
        pass = findViewById(R.id.ed_pass1);
        pass2 = findViewById(R.id.ed_pass2);
        Button reg = findViewById(R.id.btn_register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取密码
                String pwd = pass.getText().toString().trim();
                String pwd2 = pass2.getText().toString().trim();
                Toast.makeText(Register.this, "pass:" + pwd, Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwd2)) { // 判断是否为空
                    Toast.makeText(getApplicationContext(), "输入框不能为空！",
                            Toast.LENGTH_LONG).show();
                } else if ((pwd.length() != 6) || (pwd2.length() != 6)) { // 判断是否为6位
                    Toast.makeText(Register.this, "检查密码是否为6位", Toast.LENGTH_LONG).show();
                } else if (!pwd.equals(pwd2)) {//两次密码不一致
                    Toast.makeText(getApplicationContext(), "两次密码不一致！",
                            Toast.LENGTH_LONG).show();
                } else {
                    //先存储起来
                    ed.putString("pass", pwd);
                    ed.commit();
                    //再添加数据库
                    UserDao dao = new UserDao(Register.this);
                    dao.add(phone, pwd);
                    Log.d("phone...pwd:", phone + "..." + pwd);
                    //带值跳转到登录
                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra("phone", phone);
                    intent.putExtra("pass", pwd);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
