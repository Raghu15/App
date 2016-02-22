package com.example.punit.app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by punit on 12/02/2016.
 */
public class MusicPlayerActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4;
    private MediaPlayer mediaPlayer;
    private double startTime=0;
    private double finalTime=0;
    private Handler handler=new Handler();
    private int forwardTime=5000;
    private int backwardTime=5000;
    private SeekBar seekBar;
    private TextView tv1,tv2,tv3;

    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);
        b4=(Button) findViewById(R.id.btnForward);
        b2=(Button) findViewById(R.id.btnPause);
        b3=(Button) findViewById(R.id.btnNext);
        b1=(Button) findViewById(R.id.btnBack);

        tv1=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv3.setText("Song.mp3");

        mediaPlayer = MediaPlayer.create(this,R.raw.m);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setClickable(false);
        b2.setEnabled(false);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {

                    seekBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                tv2.setText(String.format("%d min,%d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));

                tv1.setText(String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
                );

                seekBar.setProgress((int) startTime);
                handler.postDelayed(UpdateSongTime, 100);
                b2.setEnabled(false);
                b3.setEnabled(true);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp =(int) startTime;
                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int temp = (int)startTime;

        if((temp-backwardTime)>0){
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
            Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
        }
    }
});}
   private Runnable  UpdateSongTime =new Runnable() {
       @Override
       public void run() {
           startTime = mediaPlayer.getCurrentPosition();
           tv1.setText(String.format("%d min, %d sec",

                   TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                   TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                           TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                   toMinutes((long) startTime))));
           seekBar.setProgress((int)startTime);
           handler.postDelayed(this, 100);

       }
   };
    }

