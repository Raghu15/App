package com.example.punit.app;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Text_to_SpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech textToSpeech;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        textToSpeech =new TextToSpeech(this,this);
        button = (Button)findViewById(R.id.btnSpeak);
        editText=(EditText)findViewById(R.id.etSpeak);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String speak = editText.getText().toString();
                textToSpeech.speak(speak,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });
    }

    @Override
    protected void onPause() {
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

        super.onPause();
    }

    @Override
    public void onInit(int status) {
    if(status == TextToSpeech.SUCCESS){
        int result =textToSpeech.setLanguage(Locale.UK);

        if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("TTS", "This Language is not supported");
        }
    }
    }
}
