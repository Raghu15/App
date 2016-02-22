package com.example.punit.app;

import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by punit on 20/01/2016.
 */
public class AlarmManager_Activity extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmmanager);

        b1 = (Button) findViewById(R.id.btnAlarm);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });
    }

    private void startAlert() {

        EditText editText =(EditText) findViewById(R.id.etAlarm);
        int i =Integer.parseInt(editText.getText().toString());
        AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this,MyBroadCastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),23,intent,0);


        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();

    }


}
