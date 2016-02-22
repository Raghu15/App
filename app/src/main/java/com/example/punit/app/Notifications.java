package com.example.punit.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by punit on 14/12/2015.
 */
public class Notifications extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);
    }
    public void generateNotification(View view){
        switch (view.getId()){
            case R.id.btnNotify:
                createNotification();
                break;
            case R.id.btnSound:
                startSound();
                break;
            case R.id.btnVibrate:
                vibrateDevice();
                break;
            case R.id.btnAll:
                createNotification();
                startSound();
                vibrateDevice();
                popToast();

                break;
            case R.id.btnLed:
                startLed();
                break;
            case R.id.btnToast:
                popToast();
                break;
        }
    }

    private void popToast() {
       Toast toast= Toast.makeText(getApplicationContext(),"New Notification",Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);

        Toast toat= Toast.makeText(getApplicationContext(),"New Notification",Toast.LENGTH_SHORT);
        toat.show();
        toast.setGravity(Gravity.LEFT, 0, 0);



    }

    private void startLed() {
        NotificationManager notification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notif = new Notification();
        notif.ledARGB = Color.argb(255, 0, 255, 0);
        notif.flags=Notification.FLAG_SHOW_LIGHTS;
        notif.ledOnMS = 3000;
        notif.ledOffMS = 2000;
        notification.notify(1234, notif);

    }


    

    private void vibrateDevice() {
        Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(1000);vibrator.vibrate(8000);

    }

    private void startSound() {
        MediaPlayer mediaPlayer=MediaPlayer.create(getBaseContext(),R.raw.baby);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();

    }

    private void createNotification() {
        NotificationCompat.Builder builder=new  NotificationCompat.Builder(getBaseContext());
        builder.setSmallIcon(R.drawable.baby);
        Bitmap icon= BitmapFactory.decodeResource(this.getResources(),R.drawable.baby);
        builder.setLargeIcon(icon);
        builder.setAutoCancel(true);
        builder.setContentInfo("15");
        builder.setContentTitle("Notification Alert, Click Me!");
        builder.setContentText("Hi, This is Android Notification Detail!");
        PendingIntent pendingIntent=PendingIntent.getActivity(this,1,new Intent(getBaseContext(),NotificationResults.class)
                ,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification notification=builder.build();

        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
