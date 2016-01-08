package com.codingrookie.kfl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by justin.leggett on 12/17/2015.
 */
public class MatchShapes extends AppCompatActivity{

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    // Used to display random images
    /*Integer[] images = new Integer[]{R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};*/

    Integer[] images = new Integer[]{R.drawable.fish, R.drawable.horse, R.drawable.ladybug, R.drawable.leopard, R.drawable.bird, R.drawable.bull, R.drawable.lion, R.drawable.cat,
            R.drawable.lobster, R.drawable.cow, R.drawable.rabbit, R.drawable.dog, R.drawable.snail, R.drawable.duck, R.drawable.turtle, R.drawable.elephant, R.drawable.bird_contour};

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

    }

    public void addListenerOnButton() {


        // Sets the question_Image_Button to either image 0 - 2, which will match
        // Chooses a random image between 0 - 2 of the array images
        Button question_Image_Button = (Button) findViewById(R.id.question_Image_Button);
        int imageIds = (int) (Math.random() * 3);

        // Used to display image in position 0

        ImageButton homeButton = (ImageButton) findViewById(R.id.homeButton);


            homeButton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    homePage();
                }
            });


        Button img = (Button) findViewById(R.id.img);

        if(imageIds == 0) {

            img.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                    refreshImages();
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

        Button img1 = (Button) findViewById(R.id.img1);

        if(imageIds == 1) {

            img1.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                    refreshImages();
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

        Button img2 = (Button) findViewById(R.id.img2);

        if(imageIds == 2) {

            img2.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                    refreshImages();
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

    }

    /*
    * Displays a custom toast when the user gets the answer correct
     */
    public void displayCorrectToast() {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.congratz_Web_View));

        WebView image = (WebView) layout.findViewById(R.id.congratz_Web_View);
        image.loadUrl("file:///android_asset/congrats.gif");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


    }

    /*
    * Displays a custom message when the user selects the wrong answer.
     */
    public void displayIncorrectToast() {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.congratz_Web_View));

        WebView image = (WebView) layout.findViewById(R.id.congratz_Web_View);
        image.loadUrl("file:///android_asset/sorry.gif");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void homePage(){
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }
}
