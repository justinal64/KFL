package com.codingrookie.kfl;
/*
* Phil 4:13
* I can do all things through
* Christ who strengthens me.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ImageButton img = (ImageButton) findViewById(R.id.homeButton);

            img.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // listener for onClick
                    sortShapes();
                }
            });

        ImageButton img1 = (ImageButton) findViewById(R.id.about);

        img1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                about();
            }
        });

        ImageButton img2 = (ImageButton) findViewById(R.id.uidesign);

        img2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                uidesign();
            }
        });

        ImageButton img3 = (ImageButton) findViewById(R.id.hpredesign);

        img3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                hpredesign();
            }
        });

        ImageButton img4 = (ImageButton) findViewById(R.id.matchShapes);

        img4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // listener for onClick
                matchShapes();
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

    public void sortShapes(){
        // Call SortShapes.java
        Intent intent = new Intent(this, SortShapes.class);
        startActivity(intent);
    }

    public void about(){
        // Call SortShapes.java
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void uidesign(){
        // Call SortShapes.java
        Intent intent = new Intent(this, UIDesign.class);
        startActivity(intent);
    }

    public void hpredesign(){
        // Call SortShapes.java
        Intent intent = new Intent(this, HPReDesign.class);
        startActivity(intent);
    }

    public void matchShapes(){
        // Call SortShapes.java
        Intent intent = new Intent(this, MatchShapes.class);
        startActivity(intent);
    }

}
