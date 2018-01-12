package com.demo.demo500px.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by max on 1/12/18.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Demo500px";
    private static final int DATABASE_VERSION = 1;

    public static final String COMMENT_TABLE_NAME = "comment";
    public static final String COMMENT_COL_IMAGE_ID = "image_id";
    public static final String COMMENT_COL_TEXT = "text";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + COMMENT_TABLE_NAME
                + "(" + COMMENT_COL_IMAGE_ID + " integer ,"
                + COMMENT_COL_TEXT + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + COMMENT_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
