package com.machamasisuraj.socialapp.Sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

public class LightSensor {
    private Context mContext;
    public LightSensor(Context mContext){
        this.mContext=mContext;
    }

    private SensorManager sensorManager;
    public void getLightInstance(){
        sensorManager= (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        SensorEventListener lightListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                    Log.i("Sensor Changed", "onSensor Change :" + event.values[0]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                if(sensor.getType() == Sensor.TYPE_LIGHT){
                    Log.i("Sensor Changed", "Accuracy :" + accuracy);
                }
            }

        };
        sensorManager.registerListener(lightListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
