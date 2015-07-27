package com.fmendez.mianimacion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {
    ImageView image=null;
    Spinner lista=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (image==null) {
            image = (ImageView) findViewById(R.id.imageView);
        }

        if (lista==null) {
            lista = (Spinner) findViewById(R.id.spinner);
            CharSequence [] datos = new CharSequence[] {"Rotar","Zoom","Clockwise","Fade","Blink","Move","Slide"};
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getApplicationContext(),android.R.layout.simple_list_item_1,datos);
            lista.setAdapter(adapter);
        }

        /*// Step1 : create the  RotateAnimation object
        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        // Step 2:  Set the Animation properties
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);*/

        // Step 3: Start animating the image


        // Later. if you want to  stop the animation
        // image.setAnimation(null);
    }

    public void iniciar(View v) {
        // Step1 : create the  RotateAnimation object
        if (lista==null) {
            lista = (Spinner) findViewById(R.id.spinner);
        }
        if (image==null) {
            image = (ImageView) findViewById(R.id.imageView);
        }

        int pos = lista.getSelectedItemPosition();
        switch (pos) {
            case 0:
                float px=0, py=0;
                if (image!=null) {
                    px=image.getWidth()/2;
                    py=image.getHeight()/2;
                }
                RotateAnimation anim = new RotateAnimation(0f, 360f, px, py);
                // Step 2:  Set the Animation properties
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(2000);
                image.startAnimation(anim);
                break;
            case 1:
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
                image.startAnimation(animation1);
                break;
            case 2:
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                image.startAnimation(animation2);
                break;
            case 3:
                Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                image.startAnimation(animation3);
                break;
            case 4:
                Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                image.startAnimation(animation4);
                break;
            case 5:
                Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                image.startAnimation(animation5);
                break;
            case 6:
                Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
                image.startAnimation(animation6);
                break;
        }


    }

    public void detener(View v) {
        image.setAnimation(null);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        setResult(300);
        super.finish();
        Log.i("app", "Finalizo dos");
    }
}
