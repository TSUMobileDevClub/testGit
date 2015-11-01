package com.example.sgt_powell.practiceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button signInBtn;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = (Button) findViewById(R.id.loginBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        regBtn = (Button) findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();
            }
        });


    }

    private void signIn(){
        //Alert Sign in
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Give us a sec while we sign you in.").setTitle("Signing In...").create().show();
    }

    private void register(){
        //Send to RegistrationActivity
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }
}
