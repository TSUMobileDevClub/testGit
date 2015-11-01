package com.example.sgt_powell.color_changing_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button redButton;
    private Button blueButton;
    private Button yellowButton;
    private TextView coloredView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coloredView = (TextView)findViewById(R.id.colorView);

        redButton = (Button)findViewById(R.id.redBtn);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coloredView.setBackgroundResource(R.color.red);

            }
        });

        blueButton = (Button)findViewById(R.id.blueBtn);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coloredView.setBackgroundResource(R.color.blue);

            }
        });


        yellowButton = (Button)findViewById(R.id.yellowBtn);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coloredView.setBackgroundResource(R.color.yellow);

            }
        });


    }



}
