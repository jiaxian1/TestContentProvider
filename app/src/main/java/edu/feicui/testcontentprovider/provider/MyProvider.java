package edu.feicui.testcontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import edu.feicui.testcontentprovider.db.MySQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyProvider extends ContentProvider{

    /**
     * 用来操作数据库
     */
    SQLiteDatabase sqLiteDatabase;
    /**
     * 用作匹配Uri的
     */
    UriMatcher matcher;
    /**
     * 表名   注意：要初始化
     */
    String tableName="";
    public static final String AUTHORITY="edu.feicui.testcontentprovider.MY_PROVIDER";
    public static final String STU="stu";
    public static final String TEA="tea";
    public static final int CODE_STU=11;
    public static final int CODE_TEA=12;
    /**
     *  true  提供者生效  可以使用
     * @return
     */
    @Override
    public boolean onCreate() {
        //初始化sqLiteDatabase
        Context context=getContext();
        MySQLiteOpenHelper openHelper=new MySQLiteOpenHelper(context);
        sqLiteDatabase=openHelper.getWritableDatabase();
        //初始化matcher
        matcher=new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY,STU,CODE_STU);
        matcher.addURI(AUTHORITY,TEA,CODE_TEA);
        return true;
    }

    /**
     *
     * @param uri   外界传过来的uri  相当于表名
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor=sqLiteDatabase.query(getTableNameFromUri(uri),projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id=sqLiteDatabase.insert(getTableNameFromUri(uri),null,values);
        Uri uriResult=Uri.parse(uri+"/"+id);
        return uriResult;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int row=sqLiteDatabase.delete(getTableNameFromUri(uri),selection,selectionArgs);
        return row;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int row=sqLiteDatabase.update(getTableNameFromUri(uri),values,selection,selectionArgs);
        return row;
    }
    public String getTableNameFromUri(Uri uri){
        //通过uri拿到具体要操作的数据对象
        int code=matcher.match(uri);
        switch (code){
            case CODE_STU://学生
                tableName=STU;
                break;
            case CODE_TEA://老师
                tableName=TEA;
                break;
        }
        return tableName;
    }
}
