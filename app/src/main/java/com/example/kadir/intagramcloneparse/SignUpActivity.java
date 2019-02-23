package com.example.kadir.intagramcloneparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    }
    public void signin(View view){

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

                }
            }
        });

    }
}
