package com.example.punit.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by punit on 17/12/2015.
 */
public class PersonalDetails extends AppCompatActivity {
    public void saveUserInfo(View view){
        String name = ((EditText)findViewById(R.id.etName)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name",name);
        setResult(RESULT_OK, intent);
        Toast.makeText(this,"name saved",Toast.LENGTH_SHORT).show();

        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_details_layout);
    }


}
