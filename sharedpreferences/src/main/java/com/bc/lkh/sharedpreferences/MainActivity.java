package com.bc.lkh.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        //1.查找控件
        final EditText name = findViewById(R.id.ed_name);
        final EditText pass = findViewById(R.id.ed_pass);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        Button login = findViewById(R.id.btn);
        //2.登录按钮实现监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //3.点击按钮后，获取输入框的内容和复选框的状态
                String count = name.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                boolean checked = checkBox.isChecked();
                //4.判断输入框是否为空，为空提示
                if (count.isEmpty()) {
                    Toast.makeText(MainActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                } else if (pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //5.存储它们的状态
                    edit.putString("username", count);
                    edit.putString("password", pwd);
                    edit.putBoolean("check", checked);
                    edit.commit();//提交
                    //6.登录成功后跳转
                    startActivity(new Intent(getApplicationContext(), MyActivity.class));
                    finish();
                }
            }
        });
        //7.一进入页面就设置输入框的值为存储的值，第一次会是空的，第二次进入若记住账号被选中，这些值就不是空的
        if (sharedPreferences.getBoolean("check", false)) {
            name.setText(sharedPreferences.getString("username", ""));
            pass.setText(sharedPreferences.getString("password", ""));
            checkBox.setChecked(sharedPreferences.getBoolean("check", false));
        }
    }
}
