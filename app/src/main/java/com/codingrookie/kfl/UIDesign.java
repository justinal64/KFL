package com.codingrookie.kfl;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;


public class UIDesign extends AppCompatActivity {

    private ImageView image;
    private TransitionDrawable trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uidesign);

        // Setting up a listener to turn steering wheel when clicked

        final ImageButton about = (ImageButton) findViewById(R.id.about);


        about.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                turnSteeringWheel(about);
            }
        });
        // End of steering wheel event

        // Setting up a listener to turn steering wheel when clicked

        final ImageButton homeButton = (ImageButton) findViewById(R.id.homeButton);


        homeButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                turnSteeringWheel(homeButton);
            }
        });
        // End of steering wheel event


        // Setting up a listener to turn steering wheel when clicked

        final ImageButton wheel = (ImageButton) findViewById(R.id.wheel);


        wheel.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                turnSteeringWheel(wheel);
            }
        });
        // End of steering wheel event

        //get the sun view
        ImageView sun = (ImageView) findViewById(R.id.sun);
        //load the sun movement animation
        AnimatorSet sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
        //set the view as target
        sunSet.setTarget(sun);
        //start the animation
        sunSet.start();


        // Darken the sky and vice verse based on sun position
        ValueAnimator skyAnim = ObjectAnimator.ofInt
                (findViewById(R.id.car_layout), "backgroundColor",
                        Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));

        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);

        skyAnim.setEvaluator(new ArgbEvaluator());

        skyAnim.start();
        // end of sky animation

        // Making the clouds move
        ObjectAnimator cloudAnim = ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);

        cloudAnim.setDuration(3000);
        cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim.start();

        ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", -300);
        cloudAnim2.setDuration(3000);
        cloudAnim2.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim2.start();
        // end of cloud animation


    }

    public void turnSteeringWheel(ImageButton wheel){
        // Start moving the steering wheel
        Log.v("MainActivity", "turnSteeringWheel was called!!!!");
        AnimatorSet wheelSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.wheel_spin);
        wheelSet.setTarget(wheel);


        wheelSet.start();
        // end of animation
    }
}