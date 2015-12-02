package com.codingrookie.kfl;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class UIDesign extends AppCompatActivity {

    private ImageView image;
    private TransitionDrawable trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uidesign);

        image = (ImageView) findViewById(R.id.image);
        Resources res = this.getResources();
        trans = (TransitionDrawable) res.getDrawable(R.drawable.transition);

        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageDrawable(trans);
                trans.reverseTransition(1000);
            }
        });
    }
}