package com.example.punit.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by punit on 09/12/2015.
 */
public class BasicCalculator extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        tvResult=(TextView) findViewById(R.id.tvResult);
        etFirstNum1=(EditText) findViewById(R.id.etFirstNum);
        etSecondNum2=(EditText) findViewById(R.id.etSecondNum);
    }
    private TextView tvResult;
    private EditText etFirstNum1;
    private EditText etSecondNum2;

    public void doCalculation(View view){
        if(etFirstNum1.getText().toString().isEmpty() ||etSecondNum2.getText().toString().isEmpty() ){
            Toast.makeText(this, "Enter the valid number", Toast.LENGTH_LONG).show();
        }else {
            double num1=Double.parseDouble(etFirstNum1.getText().toString());
            double num2=Double.parseDouble(etSecondNum2.getText().toString());


            if (view.getId() == R.id.btnAdd) {
                tvResult.setText("" + (num1 + num2));
            } else if (view.getId() == R.id.btnSub) {
                tvResult.setText("" + (num1 - num2));
            } else if (view.getId() == R.id.btnDiv) {
                tvResult.setText("" + (num1 / num2));
            } else if (view.getId() == R.id.btnMul) {
                tvResult.setText("" + (num1 * num2));
            } else if (view.getId() == R.id.btnMod) {
                tvResult.setText("" + (num1 % num2));
            }
        }

    }
}
