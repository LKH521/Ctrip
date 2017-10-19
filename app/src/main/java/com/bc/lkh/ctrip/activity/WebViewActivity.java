package com.bc.lkh.ctrip.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bc.lkh.ctrip.R;

/**
 * Created by wangye on 2017/8/2.
 */

public class WebViewActivity extends Activity {
  LinearLayout linearLayout;
  ImageView imageView;
  TextView textView;
  ProgressBar progressBar;
  WebView webView;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webviewactivity);
    imageView =  findViewById(R.id.tu);
    textView =  findViewById(R.id.load);
    progressBar =  findViewById(R.id.pbar);
    linearLayout = findViewById(R.id.lin);
    webView =  findViewById(R.id.newswebview);
    //给WebView设置属性
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);//是否支持HTML中的JS
    webSettings.setSupportZoom(true);//设置是否支持缩放
    webSettings.setBuiltInZoomControls(true);//设置是否支持缩放工具
    webSettings.setUseWideViewPort(true);//设置是否支持任意缩放大小
    webView.requestFocus();//
    webView.setWebViewClient(new WebViewClient() {
      @Override//用来处理当前链接和子链接   true表示当前页面用WebView加载  false用默认浏览器
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        webView.loadUrl(url);
        return true;
      }
      @Override//监听当前页面开始加载
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
        linearLayout.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        progressBar.setMax(100);
      }
      @Override//监听当前页面加载完毕
      public void onPageFinished(WebView view, String url) {
        linearLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
      }
    });

    webView.setWebChromeClient(new WebChromeClient(){
      @Override//监听网页加载的进度变化
      public void onProgressChanged(WebView view, int newProgress) {
        progressBar.setProgress(newProgress);
      }

      @Override//接收当前加载网页的标题
      public void onReceivedTitle(WebView view, String title) {
        textView.setText(title);
      }

      @Override//接收当前加载网页的图标
      public void onReceivedIcon(WebView view, Bitmap icon) {
        imageView.setImageBitmap(icon);
      }

      @Override//处理JS对话框
      public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return true;
      }
    });
    Intent i = getIntent();
    webView.loadUrl(i.getStringExtra("url"));
  }
}
