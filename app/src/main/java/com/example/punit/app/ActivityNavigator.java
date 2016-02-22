package com.example.punit.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by punit on 09/12/2015.
 */
public class ActivityNavigator extends AppCompatActivity {
    public static final String NEWS_TYPE="newstype";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_layout);
    }
    public void navigator(View view){
        switch(view.getId()){
            case R.id.btnFelightNews:
                Intent intentFelightNews=new Intent(getBaseContext(),NewsActivity.class);
                intentFelightNews.putExtra(NEWS_TYPE,"FelightNews");
                startActivity(intentFelightNews);
                break;
            case R.id.btnGoogleNews:
                Intent intentGoogleNews=new Intent(getBaseContext(),NewsActivity.class);
                intentGoogleNews.putExtra(NEWS_TYPE,"GoogleNews");
                startActivity(intentGoogleNews);
                break;
            case R.id.btnCalc:
                Intent intentBasicCalculator=new Intent(getBaseContext(),BasicCalculator.class);
                startActivity(intentBasicCalculator);
                break;
            case R.id.btngreetUser:
                Intent intentGreetUser=new Intent(getBaseContext(),GreetUser.class);
                startActivity(intentGreetUser);
                break;
            case R.id.btnjokes:
                Intent intentJokes=new Intent(getBaseContext(),Jokes.class);
                startActivity(intentJokes);
                break;
            case R.id.btntree:
                Intent intentTree=new Intent(getBaseContext(),Tree.class);
                startActivity(intentTree);
                break;

        }

    }
}
