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

public class CustomRegistration extends AppCompatActivity {
    private TextView username;
    private TextView email;
    private TextView password;
    private TextView password_verified;
    private ParseObject registrationData;
    private ParseUser userRegistrationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_registration);
        //Setting up parse user storage
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parseID1), getString(R.string.parseID2));
        registrationData= new ParseObject("TestObject");
        userRegistrationData = new ParseUser();

        username = (TextView) findViewById(R.id.reg_username_textfield);
        //lengthCheck(username.getText());

        email = (TextView) findViewById(R.id.reg_user_email);
        //isEmail(email.getText());

        password = (TextView) findViewById(R.id.reg_user_password);
        password_verified = (TextView) findViewById(R.id.reg_user_2nd_password);
        //passwordValidation(password.getText(), password_verified.getText());

        Button newRegisterBtn = (Button) findViewById(R.id.reg_button);
        newRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(performChecks(username.getText(), email.getText(), password.getText(), password_verified.getText())){
                    Toast.makeText(CustomRegistration.this, "Account Saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CustomRegistration.this, MainActivity.class);
                    intent.putExtra("NEW_USERNAME",username.getText());
                    intent.putExtra("NEW_PASSWORD", password.getText());
                    startActivity(intent);

                    registrationData.put("Username", username.getText());
                    registrationData.put("Email", email.getText());
                    registrationData.put("Password", password_verified.getText());
                    registrationData.saveInBackground();

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




}
