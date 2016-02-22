package com.example.punit.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by punit on 09/12/2015.
 */
public class Jokes extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_layout);
        tvJokes = (TextView) findViewById(R.id.tvJokes);
        intialize();

        tvJokes.setText(ListOfJokes.get(index = 0));


    }

    private ArrayList<String> ListOfJokes;
  private TextView tvJokes;
  private static int index=0;


    public void changeJoke(View view){
        switch (view.getId()){
            case R.id.ibprev:
                index--;
                break;

            case R.id.ibnext:
                index++;
                break;
        }
        if(index<=0)
            index=0;
        if(index>ListOfJokes.size())
            index=ListOfJokes.size();

        if(index>0 && index<ListOfJokes.size())
            tvJokes.setText(ListOfJokes.get(index));
        else
            Toast.makeText(this,"you reached either beginning or end",Toast.LENGTH_LONG ).show();


    }
    public void intialize(){
        ListOfJokes=new ArrayList<String>();
        ListOfJokes.add("Joke1");
        ListOfJokes.add("Joke2");
        ListOfJokes.add("Joke3");
        ListOfJokes.add("Joke4");
        ListOfJokes.add("Joke5");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Animation animation= AnimationUtils.loadAnimation(getBaseContext(),R.anim.clockwiseanim);
        tvJokes.startAnimation(animation);
    }
}
