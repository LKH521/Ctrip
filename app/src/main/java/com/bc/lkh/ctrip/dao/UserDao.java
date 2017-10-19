package com.bc.lkh.ctrip.dao;

import android.content.Context;
import android.database.Cursor;

import com.bc.lkh.ctrip.bean.User;
import com.bc.lkh.ctrip.db.UserHelper;


/**
 * Created by 刘凯华 on 2017/8/24.
 */

public class UserDao {
    Context c;
    private UserHelper helper;
    private User bean;


    public UserDao(Context context) {
        c = context;
        helper = new UserHelper(context);
    }

    public void add( String phone,String upass) {
        String sql = "insert into user (phone,password) values (?,?)";
        helper.db.execSQL(sql, new String[]{phone,upass});
    }


    public User queryUserByPhone(String phones) {
        bean = null;
        String sql = "select * from user where phone = ?";
        Cursor cursor = helper.db.rawQuery(sql, new String[]{phones});
        System.out.println("Cursor大小：" + cursor.getCount());
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();// 数据只有一条，所以不用循环读取，只从第一条开始读就行
            bean = new User();
            bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            bean.setPassword(cursor.getString(cursor.getColumnIndex("password")));
        }
        return bean;
    }
}
