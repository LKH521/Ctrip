package com.bc.lkh.myxutils;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

/**
 * xUtils3.0项目结构主要分为四大模块:
 * DbUtils模块(数据库模块)
 * ViewUtils模块(注解模块)
 * HttpUtils模块(网络模块)
 * BitmapUtils模块(图片模块)
 */
@ContentView(R.layout.activity_main)//注解布局
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn1)//注解变量
            Button bt1;
    @ViewInject(R.id.btn2)
    Button bt2;
    @ViewInject(R.id.btn3)
    Button bt3;
    @ViewInject(R.id.btn4)
    Button bt4;
    @ViewInject(R.id.btn5)
    Button bt5;
    @ViewInject(R.id.img)
    ImageView img;
    String url;
    Callback.Cancelable cancelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.view().inject(this); //让Activity识别注解
    }

    //按钮点击监听，注解模块
    //btn1绑定短按监听  type可以省略
    @Event(type = View.OnClickListener.class, value = R.id.btn1)
    private void myOnClickListenerBt1(View v) {
        bt1.setText("请稍后...");
        //按钮点击事件，联网模块  get方法
        String url = "http://v.juhe.cn/toutiao/index";
        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("type", "");
        params.addQueryStringParameter("key", "2ca3a5b1cb6edf55250bff550ac34325");
        cancelable = x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("data", result);
                Log.d("data", "get 1");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                bt1.setText("get获取结束");
                Log.d("data", "get 2");
            }
        });

    }

    //绑定长按监听  type可以省略   返回值必须为Boolean类型
    @Event(type = View.OnLongClickListener.class, value = R.id.btn1)
    private boolean myOnLongClickListenerBt1(View v) {
        bt1.setText("长按");
        cancelable.cancel();
        return true;
    }

    //btn2 post获取数据
    @Event(type = View.OnClickListener.class, value = R.id.btn2)
    private void myOnClickListenerBt2(View v) {
        bt2.setText("请稍后...");
        String url = "http://v.juhe.cn/toutiao/index";
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("type", "");
        params.addParameter("key", "2ca3a5b1cb6edf55250bff550ac34325");
        params.addHeader("head", "android"); //为当前请求添加一个头
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("data", result);
                Log.d("data", "post 1");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
                bt2.setText("post获取结束");
                Log.d("data", "post 2");
            }
        });
    }


    //btn3 上传文件 地址不合适，没有实现
    @Event(type = View.OnClickListener.class, value = R.id.btn3)
    private void myOnClickListenerBt3(View v) {
        String path = "/mnt/sdcard/Download/icon.jpg";
//        url="";
        RequestParams params = new RequestParams(url);
        params.setMultipart(true);
        params.addBodyParameter("file", new File(path));
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("data", result);
                Log.d("data", "上传 1");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
                bt3.setText("上传结束");
                Log.d("data", "上传 2");
            }
        });
    }

    //btn4 下载文件  下载完成后，直接显示在控件上
    @Event(type = View.OnClickListener.class, value = R.id.btn4)
    private void myOnClickListenerBt4(View v) {
        RequestParams params = new RequestParams(
        "http://08.imgmini.eastday.com//mobile//20170925//20170925150134_77ae353e7f15f1fecc294dec794238b3_3_mwpm_03200403.jpg");
        //自定义保存路径，Environment.getExternalStorageDirectory()：SD卡的根目录
        params.setSaveFilePath(Environment.getExternalStorageDirectory() + "/myapp.jpeg/");
        //自动为文件命名
        params.setAutoRename(true);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                //apk下载完成后，调用系统的安装方法
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.fromFile(result),
//                        "application/vnd.android.package-archive");
//                startActivity(intent);
                Log.d("data", "成功");
                img.setImageBitmap(BitmapFactory.decodeFile(result.getAbsolutePath()));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("data", "错误日志：" + ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
                Log.d("data", "联网结束");
            }

            //网络请求之前回调
            @Override
            public void onWaiting() {
                Log.d("data", "等待联网");
            }

            //网络请求开始的时候回调
            @Override
            public void onStarted() {
            }

            //下载的时候不断回调的方法
            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                //当前进度和文件总大小
                Log.i("JAVA", "current：" + current + "，total：" + total);
            }
        });

    }

    @Event(value = R.id.img)
    private void checkPermission(View view) {
        setPermissions();
    }
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.INTERNET       //读取设备信息
    };

    //6.0以后要在代码中动态添加权限
    private void setPermissions() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                PERMISSION[0]) != PackageManager.PERMISSION_GRANTED) {
            Log.d("data", "权限申请");
            Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(this, PERMISSION, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 1) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    PERMISSION[0]) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "写入申请成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "写入申请失败", Toast.LENGTH_SHORT).show();
            }
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    PERMISSION[1]) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "读取申请成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "读取申请失败", Toast.LENGTH_SHORT).show();
            }
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    PERMISSION[2]) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "联网申请成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "联网申请失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //btn5 使用缓存
    @Event(type = View.OnClickListener.class, value = R.id.btn5)
    private void myOnClickListenerBt5(View v) {
        RequestParams params = new RequestParams(url);
        params.setCacheMaxAge(1000 * 60); //为请求添加缓存时间
        Callback.Cancelable cancelable = x.http().get(params, new
                Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.i("JAVA", "onSuccess：" + result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                    }

                    @Override
                    public void onFinished() {
                    }

                    //result：缓存内容
                    @Override
                    public boolean onCache(String result) {
                        //在setCacheMaxAge设置范围（上面设置的是60秒）内，如果再次调用GET请
//                        求，
                        //返回true：缓存内容被返回，相信本地缓存，
                        //返回false：缓存内容被返回，不相信本地缓存，仍然会请求网络
                        Log.i("JAVA", "cache：" + result);
                        return true;
                    }
                });
    }
}
