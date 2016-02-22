package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by punit on 11/02/2016.
 */
public class JSON_ArrayParsing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonexample);

        TextView tv = (TextView) findViewById(R.id.tvJson);

        String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sachin\",\"salary\":\"50000\"}" +
                ",{\"id\":\"102\",\"name\":\"Sehwag\",\"salary\":\"60000\"}] }";

        String data= "";


        try {
            // Create the root JSONObject from the JSON string
            JSONObject jsonObject2 =new JSONObject(strJson);
            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonObject2.getJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject =jsonArray.getJSONObject(i);

                int id =Integer.parseInt(jsonObject.optString("id").toString());
                String name =jsonObject.optString("name").toString();
                float salary =Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
            tv.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
