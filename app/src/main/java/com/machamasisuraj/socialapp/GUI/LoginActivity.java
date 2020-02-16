package com.machamasisuraj.socialapp.GUI;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.machamasisuraj.socialapp.Sensors.LightSensor;
import com.machamasisuraj.socialapp.Sensors.ProximitySensor;
import com.machamasisuraj.socialapp.Sensors.ShakeDetector;
import com.machamasisuraj.socialapp.Utilities.CheckNetwork;
import com.machamasisuraj.socialapp.Utilities.NotificationBroadcaster.NotificationService;
import com.machamasisuraj.socialapp.Utilities.NotificationViewer;

import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername, etPassword;
    private TextView tvSignup;
    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvSignup = findViewById(R.id.tvSignup);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

//        etUsername.setText("suraj");
//        etPassword.setText("suraj");

        //starting backgraound process
       // startService(new Intent(LoginActivity.this, NotificationService.class));
        SensorInit();


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                etUsername.setText("");
                etPassword .setText("");
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

//        ReservationBLL reservationBLL= new ReservationBLL();
//        reservationBLL.getReservationByUser("5e3114800c6e6248b984f9b9");
    }

    public void SensorInit() {

        LightSensor lightSensor= new LightSensor(this);
        lightSensor.getLightInstance();
        ProximitySensor proximitySensor= new ProximitySensor(this);
        proximitySensor.ProximitySensor();

    }
    private void login() {

        CheckNetwork checkNetwork= new CheckNetwork(LoginActivity.this);

        if(checkNetwork.isNetworkAvailable()) {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if (Validation()) {

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
            } else {
                Toast.makeText(this, "Cannot Connect to " + BaseUrl.base_url, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean Validation(){
        //  pickupaddress,travellerCount,adult,childCounts;
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError("Can't be Empty!");
            etUsername.requestFocus();
            //  Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Can't be Empty!");
            etPassword.requestFocus();
            //  Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
              else{
            return true;
        }


    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override    protected void onResume() {

        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();

    }

}