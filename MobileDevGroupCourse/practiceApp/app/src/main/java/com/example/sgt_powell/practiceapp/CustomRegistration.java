package com.example.sgt_powell.practiceapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class CustomRegistration extends AppCompatActivity {
    private TextView username, email, password, password_verified;
    private String regUsername, regEmail, regPassword;
    private ParseUser userRegistrationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_registration);
        //Setting up parse user storage

        userRegistrationData = new ParseUser();

        username = (TextView) findViewById(R.id.reg_username_textfield);
        email = (TextView) findViewById(R.id.reg_user_email);
        password = (TextView) findViewById(R.id.reg_user_password);
        password_verified = (TextView) findViewById(R.id.reg_user_2nd_password);

        Button newRegisterBtn = (Button) findViewById(R.id.reg_button);
        newRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(performChecks(username.getText(), email.getText(), password.getText(), password_verified.getText())){
                    Toast.makeText(CustomRegistration.this, "Saving Account....", Toast.LENGTH_SHORT).show();

                    regUsername = username.getText().toString().trim();
                    regEmail = email.getText().toString().trim();
                    regPassword = password_verified.getText().toString().trim();

                    userRegistrationData.signUpInBackground();
                    userRegistrationData.setUsername(regUsername);
                    userRegistrationData.setEmail(regEmail);
                    userRegistrationData.setPassword(regPassword);
                    userRegistrationData.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(com.parse.ParseException e) {
                                Toast toast = signUpReturn(e);
                                toast.show();
                            if (e == null){
                                Intent intent = new Intent(CustomRegistration.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_none_default, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private boolean performChecks(CharSequence text, CharSequence email, CharSequence pass1, CharSequence pass2) {

        return lengthCheck(text) && isEmail(email) && passwordValidation(pass1.toString(), pass2.toString());


    }

    public boolean lengthCheck(CharSequence text) {
        if (!(text.length() >= 8)){
             Toast toast = Toast.makeText(this, "Username not long enough.", Toast.LENGTH_LONG);
            toast.show();
        }
        return text.length() >= 8;
    }

    public boolean isEmail(CharSequence email) {
        if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())){
             Toast toast = Toast.makeText(this, "Email not valid.", Toast.LENGTH_LONG);
            toast.show();
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean passwordValidation(String pass1, String pass2) {
        if (!(pass1.equals(pass2))){
             Toast toast = Toast.makeText(this, "Passwords don't match.", Toast.LENGTH_LONG);
            toast.show();
        }
        return pass1.equals(pass2);
    }

    private Toast signUpReturn(Exception e){
        if (e!=null){
            return Toast.makeText(this, "Whoa, Houston We Have A Problem: "+ e , Toast.LENGTH_SHORT);
        }else
            return Toast.makeText(this, "Congratulations New User!", Toast.LENGTH_SHORT);
    }

}
