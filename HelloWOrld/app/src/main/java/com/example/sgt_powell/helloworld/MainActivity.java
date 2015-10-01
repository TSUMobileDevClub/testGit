package com.example.sgt_powell.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = new EditText(this);
        name = (EditText)findViewById(R.id.editText);

        text = new TextView(this);
        text = (TextView)findViewById(R.id.textView);
    }

    public void sayHi(View view){

//        name.getText();

        text.setText("Hi, " + name.getText());
    }

}
