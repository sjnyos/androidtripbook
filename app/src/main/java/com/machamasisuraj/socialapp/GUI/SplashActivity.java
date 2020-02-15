package com.machamasisuraj.socialapp.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Sensors.LightSensor;
import com.machamasisuraj.socialapp.Utilities.CheckNetwork;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //light sensor ajdust brightness
                LightSensor lightSensor= new LightSensor(SplashActivity.this);
                lightSensor.getLightInstance();

                CheckNetwork checkNetwork= new CheckNetwork(SplashActivity.this);

                if(checkNetwork.isNetworkAvailable()){
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                }else{
                    Toast.makeText(SplashActivity.this, "Check the Network and Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        },2500);

    }
}
