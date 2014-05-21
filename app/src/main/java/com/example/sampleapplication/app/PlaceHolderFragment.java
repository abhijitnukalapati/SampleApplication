package com.example.sampleapplication.app;

/**
 * Created by abhijitnukalapati on 5/21/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceHolderFragment extends Fragment {

    private TextView vCounterText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.TAG, "Fragment - onCreate()");

    }

    public PlaceHolderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(MainActivity.TAG, "Fragment - onCreateView()");

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        vCounterText = (TextView) rootView.findViewById(R.id.counter);
        return rootView;
    }

    public void setCounterText(String s){
        vCounterText.setText(s);
    }

    public void setCounterText(int i){
        vCounterText.setText(String.valueOf(i));
    }

    public String getCounterText(){
        return vCounterText.getText().toString();
    }

}
