package com.example.sgt_powell.practiceapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button signInBtn;
    private Button regBtn;
    private Button facebookSignIn;
    private Button googlePlusSignIn;
    private EditText usernameTextBox;
    private EditText passwordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextBox = (EditText) findViewById(R.id.user_sign_in_name_textview);
        passwordTextBox = (EditText) findViewById(R.id.user_sign_in_password_textview);

        signInBtn = (Button) findViewById(R.id.loginBtn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        facebookSignIn = (Button) findViewById(R.id.menu_button_facebook_signin);
        facebookSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        googlePlusSignIn = (Button) findViewById(R.id.menu_button_google_plus_signin);
        googlePlusSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            Intent intent = new Intent(this, CustomRegistration.class);
            startActivity(intent);
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
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }

    private void setNewUserText(){
        Toast.makeText(MainActivity.this, "Setting Fields", Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            Toast.makeText(MainActivity.this,extras.getString("NEW_USERNAME") + " Name taken!" , Toast.LENGTH_SHORT).show();
            String username= extras.getString("NEW_USERNAME");
            String password= extras.getString("NEW_PASSWORD");
            usernameTextBox.setText(username);
            passwordTextBox.setText(password);
        }

    }
}
