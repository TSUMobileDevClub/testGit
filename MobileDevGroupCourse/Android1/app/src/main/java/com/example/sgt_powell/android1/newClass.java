package com.example.sgt_powell.android1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by SGT_POWELL on 10/15/2015.
 */
public class newClass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*----------------------------------
                     Not Visible
         ----------------------------------*/
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView createdView = new TextView(this);
        createdView.setText("Programmed TextView Added");

    }

    @Override
    protected void onStart() {
        super.onStart();
        /*----------------------------------
                        also not visible
         ----------------------------------*/
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /*----------------------------------
              recover data from bundle
         ----------------------------------*/
        onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //
    }

    @Override
    protected void onPause() {
        super.onPause();
        //when
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*----------------------------------
        what app should do when back button is clicked
         ----------------------------------*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*----------------------------------
               when app will be destroyed
         ----------------------------------*/
    }
}
