package com.codingrookie.kfl;
/*
* Phil 4:13
* I can do all things through
* Christ who strengthens me.
 */

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    /**
     * Duration of wait
     **/

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    // Used to display random images
    Integer[] images = new Integer[]{R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};

    int total_Right_Answers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This adds the listener to the image
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        scrambleArray();

/*        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        // set a dummy image
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.drawable.congratz);*/

        // set a message
/*                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("That is the correct answer!");*/




        // Sets the question_Image_Button to either image 0 - 2, which will match
        // Chooses a random image between 0 - 2 of the array images
        ImageButton question_Image_Button = (ImageButton) findViewById(R.id.question_Image_Button);
        int imageIds = (int) (Math.random() * 3);

        // Used to display image in position 0
        ImageButton img = (ImageButton) findViewById(R.id.img);

        if (imageIds == 0) {
            img.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    displayCorrectToast();
                    refreshImages();
                }
            });
        } else {
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        }

        // Used to display image in position 1
        ImageButton img1 = (ImageButton) findViewById(R.id.img1);

        if (imageIds == 1) {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayCorrectToast();
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    refreshImages();
                }
            });
        } else {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        };

        // Used to display image in position 2
        ImageButton img2 = (ImageButton) findViewById(R.id.img2);

        if (imageIds == 2) {
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayCorrectToast();
                    total_Right_Answers = total_Right_Answers + 1;
                    Log.v("MainActivity", "total_Right_Answers = " + total_Right_Answers);
                    refreshImages();
                }
            });
        } else {
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayIncorrectToast();
                }
            });
        }

        // Displays the images that the user is trying to match.
        question_Image_Button.setImageResource(images[imageIds]);

        // Displays the 1/2/3 images respectively after being scrambled.
        img.setImageResource(images[0]);
        img1.setImageResource(images[1]);
        img2.setImageResource(images[2]);


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
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        // set congratz image
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setImageResource(R.drawable.congratz);



        // display toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.FILL_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    /*
    * Displays a custom message when the user selects the wrong answer.
     */
    public void displayIncorrectToast() {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));

        // set congratz image
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        image.setImageResource(R.drawable.sorry);



        // display toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.FILL_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
