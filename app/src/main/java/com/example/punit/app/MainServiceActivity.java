package com.example.punit.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by punit on 19/01/2016.
 */
public class MainServiceActivity  extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart,buttonStop,buttonNext;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        buttonStart = (Button) findViewById(R.id.btnstart);
        buttonStop = (Button) findViewById(R.id.btnStop);
        buttonNext = (Button) findViewById(R.id.btnNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnstart:
                startService(new Intent(this, ServiceActivity.class));
                break;
            case R.id.btnStop:
                stopService(new Intent(this, ServiceActivity.class));
                break;
            case R.id.btnNext:
                Intent intent=new Intent(this,NextPage.class);
                startActivity(intent);
                break;
        }
    }
}
