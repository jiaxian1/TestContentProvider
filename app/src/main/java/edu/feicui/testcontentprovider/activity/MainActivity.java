package edu.feicui.testcontentprovider.activity;

import android.content.UriMatcher;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import edu.feicui.testcontentprovider.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 访问者
         */
//        Uri uri=Uri.parse("content://edu.feicui.testcontentprovider.MY_PROVIDER/stu");
        /**
         * 提供者
         */
//        UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
        //添加  所有可匹配的Uri  匹配不上是
//        matcher.addURI("edu.feicui.testcontentprovider.MY_PROVIDER","stu",11);
//        matcher.addURI("edu.feicui.testcontentprovider.MY_PROVIDER","tea",22);
        //拿到相应数据的匹配码
//        int code=matcher.match(uri);
//        Log.e("aaa", "onCreate: code=="+code );
    }
}
