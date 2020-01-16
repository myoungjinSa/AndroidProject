package com.example.mission3_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "contactdb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "Create table tb_contact(" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "phone, " +
                "email)";

        db.execSQL(tableSql);
    }

    //테이블 버전 정보가 변경될때만다 onUpgrade함수가 호출됨
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        if(newVersion == DATABASE_VERSION)
        {
            db.execSQL("drop table tb_contact");
            onCreate(db);
        }
    }


}
