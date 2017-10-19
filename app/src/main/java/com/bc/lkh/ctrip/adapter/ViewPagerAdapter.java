package com.bc.lkh.ctrip.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by 刘凯华 on 2017/9/5.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context mContext;
    ArrayList<ImageView> mList;

    public ViewPagerAdapter(Context con, ArrayList<ImageView> mlist) {
        mContext = con;
        mList = mlist;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {// View arg0滑动前Object arg1滑动后
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(mList.get(position % (mList.size())));
        return mList.get(position % (mList.size()));
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(mList.get(position % (mList.size())));// 删掉前前图片
    }
}
