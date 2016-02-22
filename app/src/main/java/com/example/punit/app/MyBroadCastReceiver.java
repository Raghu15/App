package com.example.punit.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by punit on 20/01/2016.
 */
public class MyBroadCastReceiver extends BroadcastReceiver {

    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context,R.raw.baby);
        mp.start();
        Toast.makeText(context,"Alarm..",Toast.LENGTH_LONG).show();
    }
}
