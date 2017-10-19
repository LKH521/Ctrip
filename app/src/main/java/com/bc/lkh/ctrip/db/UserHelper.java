package com.bc.lkh.ctrip.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 刘凯华 on 2017/8/24.
 */

public class UserHelper extends SQLiteOpenHelper {
    public SQLiteDatabase db = getReadableDatabase();

    public UserHelper(Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user(_id integer primary key autoincrement,phone text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
