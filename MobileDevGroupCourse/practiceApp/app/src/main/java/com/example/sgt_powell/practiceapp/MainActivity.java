package com.example.sgt_powell.practiceapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends AppCompatActivity {

    private EditText usernameTextBox;
    private EditText passwordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());

//        Parse.enableLocalDatastore(this);
//        Parse.initialize(this, getString(R.string.parseID1), getString(R.string.parseID2));
//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("C", "Created");
//        testObject.saveInBackground();

        usernameTextBox = (EditText) findViewById(R.id.user_sign_in_name_textview);
//        usernameTextBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    usernameTextBox.setError("Username cannot  be blank!");
//                }
//            }
//        });
        passwordTextBox = (EditText) findViewById(R.id.user_sign_in_password_textview);
//        passwordTextBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                passwordTextBox.setError("Email cannot  be blank!");
//            }
//        });

        Button signInBtn = (Button) findViewById(R.id.loginBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        Button facebookSignIn = (Button) findViewById(R.id.menu_button_facebook_signin);
        facebookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Button googlePlusSignIn = (Button) findViewById(R.id.menu_button_google_plus_signin);
        googlePlusSignIn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    googlePlusSignIn.setBackgroundResource(R.drawable.btn_google__signin_dark_pressed_hdpi);
                    return true;
                }else{
                    googlePlusSignIn.setBackgroundResource(R.drawable.btn_google__signin_dark_normal_hdpi);
                }

                return false;
            }
        });
//        googlePlusSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                googlePlusSignIn.setBackgroundResource(R.drawable.btn_google__signin_dark_pressed_hdpi);
//            }
//        });

        googlePlusSignIn.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                googlePlusSignIn.setBackgroundResource(R.drawable.btn_google__dark_pressed_hdpi);
                return false;
            }
        });

        Button regBtn = (Button) findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(MainActivity.this, "Activity Resumed", Toast.LENGTH_SHORT).show();

        setNewUserText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings){
            Intent i = new Intent(this, RegistrationActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

        private void signIn(){
        //Alert Sign in
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Give us a sec while we sign you in.").setTitle("Signing In...").create().show();
    }

    private void register(){
        //Send to RegistrationActivity
        Intent intent = new Intent(this, CustomRegistration.class);
        startActivity(intent);
    }

    private void setNewUserText(){

    }
}
