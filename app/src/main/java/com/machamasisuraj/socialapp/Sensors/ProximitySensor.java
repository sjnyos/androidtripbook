package com.machamasisuraj.socialapp.Sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import android.widget.Toast;

import com.machamasisuraj.socialapp.GUI.BottomNavbarActivity;

public class ProximitySensor {
    private Context mContext;

    public ProximitySensor(Context mContext) {
        this.mContext = mContext;
    }

    public void ProximitySensor() {
        SensorManager mySensorManager;
        Sensor myProximitySensor;
        mySensorManager = (SensorManager) mContext.getSystemService(
                Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            Toast.makeText(mContext, "No Proximity Sensor!", Toast.LENGTH_SHORT).show();
        } else {
//            mySensorManager.registerListener(proximitySensorEventListener,
//                    myProximitySensor,
//                    SensorManager.SENSOR_DELAY_NORMAL);
        }


    }
//    SensorEventListener proximitySensorEventListener
//            = new SensorEventListener() {
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//            // TODO Auto-generated method stub
//        }
//        @Override
//        public void onSensorChanged(SensorEvent event) {
//            // TODO Auto-generated method stub
//            WindowManager.LayoutParams params = mContext.getWindow().getAttributes();
//            if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
//
//                if(event.values[0]==0){
//                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
//                    params.screenBrightness = 0;
//                    getWindow().setAttributes(params);
//                }
//                else{
//                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
//                    params.screenBrightness = -1f;
//                    getWindow().setAttributes(params);
//                }
//            }
//        }
//    };
}
