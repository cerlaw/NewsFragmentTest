package com.example.dell.fragmentpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by DELL on 2016/11/7.
 */

public class NewsContentActivity extends Activity {
    public static void actionStart(Context context, String newsTitle,
                                   String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        //获取传入的内容
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newscontentfragment = (NewsContentFragment)
                getFragmentManager().
                        findFragmentById(R.id.news_content_fragment);
        newscontentfragment.refresh(newsTitle,newsContent);
        //刷新NewsContentFragment界面

    }
}

