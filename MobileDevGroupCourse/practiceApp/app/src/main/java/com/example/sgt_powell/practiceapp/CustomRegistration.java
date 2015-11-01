package com.example.sgt_powell.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomRegistration extends AppCompatActivity {
    private Button newRegisterBtn;
    private TextView username;
    private TextView email;
    private TextView password;
    private TextView password_verified;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_registration);

        username = (TextView) findViewById(R.id.reg_username_textfield);
        //lengthCheck(username.getText());

        email = (TextView) findViewById(R.id.reg_user_email);
        //isEmail(email.getText());

        password = (TextView) findViewById(R.id.reg_user_password);
        password_verified = (TextView) findViewById(R.id.reg_user_2nd_password);
        //passwordValidation(password.getText(), password_verified.getText());

        newRegisterBtn = (Button) findViewById(R.id.regBtn);
        newRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performChecks(username.getText(), email.getText(), password.getText(), password_verified.getText());
            }
        });


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

    public boolean passwordValidation(CharSequence pass1, CharSequence pass2) {
        if (!(pass1 == pass2)){
             Toast toast = Toast.makeText(this, "Passwords don't match.", Toast.LENGTH_LONG);
            toast.show();
        }
        return pass1 == pass2;
    }


    protected boolean performChecks(CharSequence text, CharSequence email, CharSequence pass1, CharSequence pass2) {

        return lengthCheck(text) && isEmail(email) && passwordValidation(pass1, pass2);


}

}
