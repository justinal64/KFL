package com.codingrookie.kfl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // No longer needed
    ImageButton heart;
    ImageButton circle;
    ImageButton triangle;

    // Used to display a random image
    int[] images = {R.drawable.img_0, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5};

    // Test to get random working
    final Random rnd = new Random();
    // End of test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This adds the listener to the image
        addListenerOnButton();

    }

    protected final static int getResourceID
            (final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }

    public void addListenerOnButton() {

        ImageButton img = (ImageButton) findViewById(R.id.img);
        Random generator = new Random();
        int randomImageId = images[generator.nextInt(images.length)];
        img.setImageResource(randomImageId);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton img1 = (ImageButton) findViewById(R.id.img1);
        randomImageId = images[generator.nextInt(images.length)];
        img1.setImageResource(randomImageId);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton img2 = (ImageButton) findViewById(R.id.img2);
        randomImageId = images[generator.nextInt(images.length)];
        img2.setImageResource(randomImageId);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
            }


        });
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
