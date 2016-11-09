package edu.feicui.testcontentprovider.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context) {


        super(context, "test_db", null, 1);
    }

    /**
     * 建表  提供者访问的
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStu="create table stu (_id integer,name text,level integer)";
        String sqlTea="create table tea (_id integer,name text,level integer)";
        db.execSQL(sqlStu);
        db.execSQL(sqlTea);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
