package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by punit on 18/01/2016.
 */
public class LifeCycle extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d("lifeCycle","onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "onResume invoked");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeCycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "onDestroy invoked");
    }
}
