package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by punit on 22/12/2015.
 */
public class ListViewDemo extends AppCompatActivity {
    private ListView lvColors;
    private ArrayList<String> Colour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);
        lvColors=(ListView) findViewById(R.id.lvColors);
        initialize();
    }

    private void initialize() {
    Colour=new ArrayList<String>();
        Colour.add("Blue");
        Colour.add("Black");
        Colour.add("Red");
        Colour.add("Green");
        Colour.add("Yellow");
        Colour.add("Violet");
        Colour.add("Blue");
        Colour.add("Black");
        Colour.add("Red");
        Colour.add("Green");
        Colour.add("Yellow");
        Colour.add("Violet");


    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Colour);
        lvColors.setAdapter(arrayAdapter);

        lvColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
