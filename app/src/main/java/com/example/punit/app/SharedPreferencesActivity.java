package com.example.punit.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by punit on 12/02/2016.
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button btnSave;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        btnSave=(Button) findViewById(R.id.btnSave);
        sharedpreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = et1.getText().toString();
                String ph  = et2.getText().toString();
                String e  = et3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Phone,ph);
                editor.putString(Email,e);
                editor.commit();
                Toast.makeText(getBaseContext(), "Thanks", Toast.LENGTH_LONG).show();


            }
        });
    }
}
