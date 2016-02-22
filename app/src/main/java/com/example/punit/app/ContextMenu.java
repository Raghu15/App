package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by punit on 19/01/2016.
 */
public class ContextMenu extends AppCompatActivity{

    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        ListView lvResult = (ListView) findViewById(R.id.lvResult);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        lvResult.setAdapter(adapter);

        registerForContextMenu(lvResult);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"sms");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()== "call") {

            Toast.makeText(getBaseContext(), "calling code", Toast.LENGTH_LONG).show();
        }else if(item.getTitle()=="sms"){
            Toast.makeText(getBaseContext(),"sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
  return true;
    }
}
