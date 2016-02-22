package com.example.punit.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by punit on 09/12/2015.
 */
public class NewsActivity extends AppCompatActivity {
    private TextView tvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_layout);
        tvNews = (TextView) findViewById(R.id.tvnews);


        Intent incommingIntentObject = getIntent();
        setTitle(incommingIntentObject.getStringExtra(ActivityNavigator.NEWS_TYPE));
        tvNews.setText(" I will show " + incommingIntentObject.getStringExtra(ActivityNavigator.NEWS_TYPE) + "  news");


    }
}
