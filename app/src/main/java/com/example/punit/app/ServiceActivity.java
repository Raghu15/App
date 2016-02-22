package com.example.punit.app;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by punit on 19/01/2016.
 */
public class ServiceActivity extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();

        mediaPlayer = MediaPlayer.create(this,R.raw.baby);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }

    @Override
    public void onStart(Intent intent, int startId) {

        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"Service Stopped",Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
    }


}
