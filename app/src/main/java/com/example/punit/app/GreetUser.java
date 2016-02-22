package com.example.punit.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by punit on 01/12/2015.
 */
public class GreetUser extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetuser);
    }
   public void greetUser(View view){
       EditText etName=(EditText) findViewById(R.id.etName);
       TextView textView=(TextView) findViewById(R.id.tvResult);
       String name=etName.getText().toString();
       textView.setText("Hello" + name);
   }

}
