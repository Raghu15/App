package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by punit on 12/01/2016.
 */
public class Orientation extends AppCompatActivity {
    EditText editText1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orientation_layout);
        editText1=(EditText)findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);
    }
    public void onClick(View v){
        editText1.setText("O android");
    }
}
