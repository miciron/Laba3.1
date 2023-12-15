package com.gnfosst.tbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cmDB";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "cmTable ";
    public static final String COLUMN_ID = "ID ";
    public static final String COLUMN_ID2 = "ID";
    public static final String COLUMN_FIO = "FIO ";
    public static final String COLUMN_FIO2 = "FIO";
    public static final String COLUMN_TIME = "Time ";
    public static final String COLUMN_TIME2 = "Time";

    private static final String TABLE_CREATE =
            "create table  " + TABLE_NAME + " (" +
                    COLUMN_ID + "integer primary key autoincrement, " +
                    COLUMN_FIO + "text, " +
                    COLUMN_TIME + " datetime default CURRENT_TIME)";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists " + TABLE_NAME);
    onCreate(db);
    }
}
