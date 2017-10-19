package com.bc.lkh.liukaihua_test.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bc.lkh.liukaihua_test.R;

/**
 * Created by 刘凯华 on 2017/9/11.
 */

public class AnimaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim);
        init();
    }

    private void init() {
        ImageView img = findViewById(R.id.welcome);
        Animation animation1 = AnimationUtils.loadAnimation(AnimaActivity.this, R.anim.alpha);
        animation1.setDuration(3000);
        animation1.setFillAfter(true);
        img.startAnimation(animation1);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(AnimaActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
