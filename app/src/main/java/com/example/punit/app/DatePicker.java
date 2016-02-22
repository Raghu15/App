package com.example.punit.app;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePicker extends AppCompatActivity {

    Button button1,button2;

    static final int DATE_DIALOG = 0;
    static final int TIME_DIALOG =1;

    public int myear,mmonth,mday,mhour,mminute;


    public DatePicker(){
    final Calendar cal = Calendar.getInstance();
        myear = cal.get(Calendar.YEAR);
        mmonth = cal.get(Calendar.MONTH);
        mday = cal.get(Calendar.DAY_OF_MONTH);
        mhour = cal.get(Calendar.HOUR_OF_DAY);
        mminute = cal.get(Calendar.MINUTE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        button1 =(Button) findViewById(R.id.btnDate);
        button2 =(Button) findViewById(R.id.btnTime);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        myear = year;
            mmonth = monthOfYear;
            mday = dayOfMonth;
            button1.setText("DateSelected:" +mday+ "/"+mmonth+ "/" + myear);
        }
    };

    private TimePickerDialog.OnTimeSetListener mTimeListner = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mhour=hourOfDay;
            mminute=minute;
            button2.setText("SelectTime:"+mhour+ "/" +mminute);
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch(id){
            case  DATE_DIALOG:
                return new DatePickerDialog(this,mDateListener,myear,mmonth,mday);
            case TIME_DIALOG:
                return new TimePickerDialog(this,mTimeListner,mhour,mminute,false);
        }
   return null;
    }
}
