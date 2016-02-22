package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by punit on 11/02/2016.
 */
public class JSONExample extends AppCompatActivity {

    public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonexample);

        TextView textView = (TextView) findViewById(R.id.tvJson);

        try {
            JSONObject emp = new JSONObject(JSON_STRING).getJSONObject("employee");
            String empname = emp.getString("name");
            int empsalary = emp.getInt("salary");

            String str = "Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;
            textView.setText(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
