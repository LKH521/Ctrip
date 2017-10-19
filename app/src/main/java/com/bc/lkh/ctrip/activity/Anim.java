package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bc.lkh.ctrip.R;

/**
 * Created by 刘凯华 on 2017/9/4.
 */

public class Anim extends Activity {
    ImageView img;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim);
        init();
    }

    private void init() {
        img = findViewById(R.id.img);
//        AnimationDrawable a = (AnimationDrawable) img.getBackground();
//        a.start();
        Animation anim = AnimationUtils.loadAnimation(Anim.this, R.anim.mogu);
        img.startAnimation(anim);
        sharedPreferences = getSharedPreferences("RegisterUser", MODE_PRIVATE);
        new Thread() {
            @Override
            public void run() {
                try {
                    //系统睡眠三秒，给予动画时间
                    sleep(3000);
                    Intent i;
                    //动画完成后，判断是否是第一次进入，需要用SharedPreferences记录是否进入过
                    if (sharedPreferences.getBoolean("isRun", false)) {//true代表运行过
                        i = new Intent(Anim.this, HomeActivity.class);
                    } else {
                        editor = sharedPreferences.edit();
                        editor.putBoolean("isRun", true);
                        editor.commit();
                        i = new Intent(Anim.this, ViewPagerActivity.class);
                    }
                    startActivity(i);
                    finish();
                    //Activity之间的动画切换
                    overridePendingTransition(R.anim.in, R.anim.out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
