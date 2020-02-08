package com.machamasisuraj.socialapp.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.machamasisuraj.socialapp.BLL.AdminBLL;
import com.machamasisuraj.socialapp.BLL.ReservationBLL;
import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;

import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername, etPassword;
    private TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvSignup = findViewById(R.id.tvSignup);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername.setText("suraj");
        etPassword.setText("suraj");



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(); }
        });

//        ReservationBLL reservationBLL= new ReservationBLL();
//        reservationBLL.getReservationByUser("5e3114800c6e6248b984f9b9");
    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        UserBLL loginBLL = new UserBLL();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, BottomNavbarActivity.class);
            intent.putExtra("token", BaseUrl.token);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();
        }
    }
}