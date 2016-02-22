package com.example.punit.app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by punit on 09/12/2015.
 */
public class SplashScreen extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvmoment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);
        ivImage=(ImageView) findViewById(R.id.ivImage);
        tvmoment=(TextView) findViewById(R.id.tvmoment);

        Handler handler=new Handler();
        Runnable obj=new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getBaseContext(),ActivityNavigator.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(obj, 3000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeanim);
        //ivLogo.setAnimation(animation);
        ivImage.startAnimation(animation);

        Animation animat = AnimationUtils.loadAnimation(getBaseContext(), R.anim.blinkanim);
        //ivLogo.setAnimation(animation);
        ivImage.startAnimation(animation);

        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(tvmoment, "rotation", 0,360,0,360,90,0);
        rotateAnimation.setDuration(1000);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(tvmoment, "alpha", 0.5F, 0.9F, 0, 1.0F);
        alphaAnimation.setDuration(1000);
        ObjectAnimator moveXAnimation = ObjectAnimator.ofFloat(tvmoment, "translationX", 0,100,0,-100,0, -100,0, -100);
        moveXAnimation.setDuration(1000);

        AnimatorSet set = new AnimatorSet();
        set.play(rotateAnimation).after(moveXAnimation).with(alphaAnimation);
        set.start();
    }

   }

