package com.codingrookie.kfl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;

import java.util.Arrays;
import java.util.Collections;


/**
 * Phil 4:13
 * I can do all things through Christ who gives me strength.
 */
public class MatchShapes extends AppCompatActivity{

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    // Used to display random images
    /*Integer[] images = new Integer[]{R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};*/

    // Make sure it is ok to use these!!!!!
    /*http://iconsparadise.com/animal-free-icons/animals-mini/*/

    Integer[] images = new Integer[]{R.drawable.fish, R.drawable.horse, R.drawable.ladybug, R.drawable.leopard, R.drawable.bull, R.drawable.lion, R.drawable.cat,
            R.drawable.lobster, R.drawable.cow, R.drawable.rabbit, R.drawable.dog, R.drawable.snail, R.drawable.duck, R.drawable.turtle, R.drawable.elephant, R.drawable.bird};

    int total_Right_Answers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_shapes);

        /*Removed the Toolbar*/
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        // This adds the listener to the image
        scrambleArray();
        addListenerOnButton();
        slide();
    }

    public void addListenerOnButton() {


        // Sets the question_Image_Button to either image 0 - 2, which will match
        // Chooses a random image between 0 - 2 of the array images
        Button question_Image_Button = (Button) findViewById(R.id.question_Image_Button);
        int imageIds = (int) (Math.random() * 3);

        final Button img = (Button) findViewById(R.id.img);

        if(imageIds == 0) {

            img.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                }
            });
        } else {
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        }

        final Button img1 = (Button) findViewById(R.id.img1);
        if(imageIds == 1) {

            img1.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                }
            });
        } else {
            img1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        }


        final Button img2 = (Button) findViewById(R.id.img2);
        if(imageIds == 2) {

            img2.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                }
            });
        } else {
            img2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        }

        // Displays the images that the user is trying to match.
        question_Image_Button.setBackgroundResource(images[imageIds]);

        // Displays the 1/2/3 images respectively after being scrambled.
        img.setBackgroundResource(images[0]);
        img1.setBackgroundResource(images[1]);
        img2.setBackgroundResource(images[2]);


    }


    public void slide(){

        // This animates the images to make them move from the side to there resprecitve positions
        // Is there a way to use a for loop for this?
        // How to I change the img name from Img to Img1, Img2...

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide1);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide2);
        /*Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.question_image_button);*/

        Button image = (Button)findViewById(R.id.img);
        Button image1 = (Button)findViewById(R.id.img1);
        Button image2 = (Button)findViewById(R.id.img2);
        /*Button image3 = (Button)findViewById(R.id.question_Image_Button);*/

        image.startAnimation(animation1);
        image1.startAnimation(animation2);
        image2.startAnimation(animation3);
        /*image3.startAnimation(animation3);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    * Scrambles the images in the array
    */
    public void scrambleArray() {

        Collections.shuffle(Arrays.asList(images));

    }

    /*
     * This is used to refresh img, img1, and img2 and question_Image_Button once
     * the user has picked the matching images.
    */

    public void refreshImages() {
        scrambleArray();
        addListenerOnButton();
        slide();

    }

    /*
    * Displays a custom toast when the user gets the answer correct
     */
    public void displayCorrectToast() {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.correct_custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));


        Toast toast = new Toast (this);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshImages();
            }
        }, 2000);


    }

    /*
    * Displays a custom message when the user selects the wrong answer.
     */
    public void displayIncorrectToast() {


        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.incorrect_custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        Toast toast = new Toast (this);
        toast.setView(view);
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.show();

    }

    public void homePage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
