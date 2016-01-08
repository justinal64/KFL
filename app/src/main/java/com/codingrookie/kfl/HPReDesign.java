package com.codingrookie.kfl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.transition.TransitionManager;

/**
 * Created by justin.leggett on 12/11/2015.
 */
public class HPReDesign extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hpredesign);


        Button img = (Button) findViewById(R.id.button1);

        img.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                test();
            }
        });

        Button img1 = (Button) findViewById(R.id.button2);

        img1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                test();
            }
        });

        Button img2 = (Button) findViewById(R.id.button3);

        img2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                test();
            }
        });

        Button img3 = (Button) findViewById(R.id.button4);

        img3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                test();
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


    public void about(){
        // Call SortShapes.java
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void test(){
        Log.v("MainActivity", "Button was clicked!!!");

    }
}
