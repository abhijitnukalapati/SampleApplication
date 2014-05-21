package com.example.sampleapplication.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private PlaceHolderFragment mPlaceHolderFragment;
    private final String COUNTER_VALUE  = "counterValue";
    public final static String TAG = "sample";
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(MainActivity.TAG, "Activity - onCreate()");


        // If we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            ((PlaceHolderFragment)getFragmentManager().findFragmentByTag("placeHolder")).setCounterText(savedInstanceState.getInt(COUNTER_VALUE));
            return;
        } else {
            mPlaceHolderFragment = new PlaceHolderFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, mPlaceHolderFragment, "placeHolder")
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // the following call ensures the default state restoration is
        // performed
        super.onSaveInstanceState(outState);

        outState.putInt(COUNTER_VALUE, Integer.valueOf(((PlaceHolderFragment) getFragmentManager().findFragmentByTag("placeHolder")).getCounterText()));
    }

    public void incrementCounter(View v) {
        ++counter;
        ((PlaceHolderFragment)getFragmentManager().findFragmentByTag("placeHolder")).setCounterText(counter);
    }

    public void decrementCounter(View v) {
        if(counter > 0) {
            --counter;
            ((PlaceHolderFragment)getFragmentManager().findFragmentByTag("placeHolder")).setCounterText(counter);
        }
    }

}
