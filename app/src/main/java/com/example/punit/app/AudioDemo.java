package com.example.punit.app;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by punit on 21/12/2015.
 */
public class AudioDemo extends AppCompatActivity {
    private String audioFilePath;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_demo_layout);
    }
    public void playAudio(View view){
        if(audioFilePath != null){
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(audioFilePath);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please select Audio File First !!", Toast.LENGTH_LONG).show();
        }
    }

    public void stopAudio(View view){
        if(mediaPlayer != null)
            mediaPlayer.stop();
        else
            Toast.makeText(this, "play a song first !!! ", Toast.LENGTH_LONG).show();
    }

    public void selectAudio(View view){
        Intent intentAudio=new Intent(Intent.ACTION_GET_CONTENT);
        intentAudio.setType("file/*");
        startActivityForResult(intentAudio,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        audioFilePath = data.getData().getPath();
        Toast.makeText(this, audioFilePath, Toast.LENGTH_LONG).show();
    }
}
