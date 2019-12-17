package com.machamasisuraj.socialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editText,editText2;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        btnLogin = findViewById(R.id.button1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();

            }
        });
    }
    public void Signup(){
        SharedPreferences sharedPreferences =  getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("username",editText.getText().toString());
        editor.putString("password",editText2.getText().toString());
        editor.commit();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
    private void checkUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String username =  sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");
        if(username.equals(editText.getText().toString()) && password.equals(editText2.getText().toString())){
            Toast.makeText(this, "Successful Login", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Either username or passsword is incorrect", Toast.LENGTH_SHORT).show();
            Signup();
        }
    }
}
