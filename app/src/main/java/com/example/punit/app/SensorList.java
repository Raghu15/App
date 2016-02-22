package com.example.punit.app;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by punit on 22/12/2015.
 */
public class SensorList extends AppCompatActivity {
    private ListView lvSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_layout_layout);
        lvSensorList=(ListView) findViewById(R.id.lvSensorList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        ArrayList<String> sensorDetailsList = new ArrayList<String>();

        for(Sensor sensor: sensorList){
            sensorDetailsList.add(sensor.getName() + " " + sensor.getVendor() + " " + sensor.getPower());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorDetailsList);
        lvSensorList.setAdapter(adapter);
    }
}
