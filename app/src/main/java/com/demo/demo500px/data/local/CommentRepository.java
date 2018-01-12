package com.demo.demo500px.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.demo.demo500px.data.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 1/12/18.
 */

public class CommentRepository {

    private DBHelper mDb;

    public CommentRepository(Context context) {
        mDb = new DBHelper(context);
    }

    public void addComment(long id, String text){
        SQLiteDatabase db = mDb.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.COMMENT_COL_IMAGE_ID, id);
        contentValues.put(DBHelper.COMMENT_COL_TEXT, text);

        db.insert(DBHelper.COMMENT_TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<Comment> getComments(long id){
        SQLiteDatabase db = mDb.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + DBHelper.COMMENT_TABLE_NAME
                + " where " + DBHelper.COMMENT_COL_IMAGE_ID + "=" + id, null);

        ArrayList<Comment> comments = new ArrayList<>();

        if (res.moveToFirst()){
            int colid = res.getColumnIndex(DBHelper.COMMENT_COL_IMAGE_ID);
            int coltext = res.getColumnIndex(DBHelper.COMMENT_COL_TEXT);

            do {
                comments.add(new Comment(res.getLong(colid), res.getString(coltext)));
            }while (res.moveToNext());
        }

        res.close();
        db.close();
        return comments;
    }
}
