package com.codingrookie.kfl;
/*
* Phil 4:13
* I can do all things through
* Christ who strengthens me.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // Used to display a random image
    /*int[] images = {R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};*/

    Integer[] images = new Integer[]{R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};


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

        // Scrambles the images in the array
        Collections.shuffle(Arrays.asList(images));

        // Sets the question_Image_Button to either image 0 - 2, which will match
        // one of the images being displayed in the choices above.
        ImageButton question_Image_Button = (ImageButton) findViewById(R.id.question_Image_Button);
        int imageIds = (int) (Math.random() * 3);

        // Used to display image in position 0
        ImageButton img = (ImageButton) findViewById(R.id.img);

        if(imageIds == 0) {
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Congratulations that is correct!!!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Used to display image in position 1
        ImageButton img1 = (ImageButton) findViewById(R.id.img1);

        if(imageIds == 1) {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Congratulations that is correct!!!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
                }
            });
        };

        // Used to display image in position 2
        ImageButton img2 = (ImageButton) findViewById(R.id.img2);

        if(imageIds == 2) {
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Congratulations that is correct!!!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,
                            "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
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
}
