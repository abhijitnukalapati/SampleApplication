package com.example.sampleapplication.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity implements PlaceHolderFragment.IManageCounterListener{

    private final String LOG_TAG = "sample";
    private final String COUNTER_VALUE  = "counterValue";
    private final String FRAGMENT_TAG = "placeHolder";

    private PlaceHolderFragment mPlaceHolderFragment;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Activity - onCreate()");

        // If we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_VALUE, 0);
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

        outState.putInt(COUNTER_VALUE, counter);
    }

    public void incrementCounter(View v) {
        ++counter;
        updateFragmentCounterText();
    }

    public void decrementCounter(View v) {
        if(counter > 0) {
            --counter;
            updateFragmentCounterText();
        }
    }

    @Override
    public int getCounterValue() {
        return counter;
    }


    private void updateFragmentCounterText(){
        PlaceHolderFragment placeHolderFragment = (PlaceHolderFragment)getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        try {
            placeHolderFragment.setCounterText(counter);
        } catch (NullPointerException npe) {
            Log.d(LOG_TAG, "Couldn't set text for the counter field. The PlaceHolderFragment is null. How come?");
        }
    }
}
