package com.example.sampleapplication.app;

/**
 * Created by abhijitnukalapati on 5/21/14.
 */

import android.app.Activity;
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

    public static interface IManageCounterListener {
        public int getCounterValue();
    }

    private final String LOG_TAG = "sample";
    private IManageCounterListener mManageCounterListener;
    private TextView vCounterText;

    public PlaceHolderFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment - onCreate()");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mManageCounterListener = (IManageCounterListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment - onCreateView()");

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        vCounterText = (TextView) rootView.findViewById(R.id.counter);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setCounterText(mManageCounterListener.getCounterValue());
    }

    public void setCounterText(int i){
        vCounterText.setText(String.valueOf(i));
    }

}
