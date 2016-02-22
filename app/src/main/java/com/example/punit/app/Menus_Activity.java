package com.example.punit.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by punit on 18/01/2016.
 */
public class Menus_Activity extends AppCompatActivity {

    TextView tvMenus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle()=="Help"){
            Intent intent =new Intent(this,Analog_Digital_Clock.class);
            startActivity(intent);
        }else
        Toast.makeText(this,"you selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Help");
        menu.add("About");
        menu.add("Setting");
        return super.onCreateOptionsMenu(menu);

    }


}
