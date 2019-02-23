package com.example.kadir.intagramcloneparse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usernameText = findViewById(R.id.sign_up_activity_name_text);
        passwordText = findViewById(R.id.sign_up_activity_password_text);
        ParseUser parseUser = ParseUser.getCurrentUser();
        if(parseUser !=null){
            Intent intent = new Intent(getApplicationContext(),FeedAvtivity.class);
            startActivity(intent);
        }
    }
    public void signin(View view){
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
            if(e!=null){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Welcome " +user.getUsername(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),FeedAvtivity.class);
                startActivity(intent);
            }
            }
        });

    }
    public void signup(View view){
        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e !=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Kayıt Tamam",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),FeedAvtivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
