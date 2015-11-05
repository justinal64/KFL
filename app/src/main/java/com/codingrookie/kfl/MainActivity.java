package com.codingrookie.kfl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton heart;
    ImageButton circle;
    ImageButton triangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        // This adds the listener to the image
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        // Listener for the heart
        heart = (ImageButton) findViewById(R.id.heart);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Sorry that doesn't match try again", Toast.LENGTH_SHORT).show();
            }


        });

        // Listener for the circle
        circle = (ImageButton) findViewById(R.id.circle);

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get your custom_toast.xml layout
                LayoutInflater inflator = getLayoutInflater();

                View layout = inflator.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout_id));

                // Set an image to display
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.drawable.congratz);

                // Toast...
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

/*                Toast.makeText(MainActivity.this,
                        "Congratulations your correct!!!", Toast.LENGTH_SHORT).show();*/
            }


        });

        // Listener for the triangle
        triangle = (ImageButton) findViewById(R.id.triangle);

        triangle.setOnClickListener(new View.OnClickListener() {
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
