package com.beicai.wangbo.cardviewdemo;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    SlidingMenu menu;
    private static Interpolator interp = new Interpolator() {
        @Override
        public float getInterpolation(float t) {
            t -= 1.0f;
            return t * t * t + 1.0f;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cv = (CardView) findViewById(R.id.cv);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slid();
                menu.toggle();
                Toast.makeText(MainActivity.this, "SlidingMenu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void slid() {
        menu = new SlidingMenu(this);
        // 6.设置滑动的方向
        menu.setMode(SlidingMenu.RIGHT);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(1.0f);
        //    设置滑动时拖拽效果
        menu.setBehindScrollScale(1);
        menu.setFadeEnabled(true);
        menu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
//                canvas.scale(percentOpen,1,0,0);//折叠动画
                //缩放动画
//                float scale = (float) (percentOpen*0.25 + 0.75);
//                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
                //上升动画
                canvas.translate(0, canvas.getHeight() * (1 - interp.getInterpolation(percentOpen)));
            }
        });
        // 设置宽高
        // 1.获取窗口管理对象
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        // 2.获取显示对象
        Display display = manager.getDefaultDisplay();
        // 3.通过构造方法获取属性对象
        DisplayMetrics met = new DisplayMetrics();
        // 4.把显示对象的属性传给属性对象
        display.getMetrics(met);
        int width = met.widthPixels * 3 / 4;
        menu.setBehindWidth(width);
        // 5.设置滑动在 上面的页面有效 // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        // 为侧滑菜单设置布局
        menu.setMenu(R.layout.slid);
    }
}
