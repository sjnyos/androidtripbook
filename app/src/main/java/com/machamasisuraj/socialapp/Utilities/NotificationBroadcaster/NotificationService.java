package com.machamasisuraj.socialapp.Utilities.NotificationBroadcaster;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Utilities.NotificationChannel.CreateChannel;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationService  extends Service {
   private  Timer mTimer;
   private TimerTask timerTask= new TimerTask() {
       @Override
       public void run() {
           notifyNow();
       }
   };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        mTimer.schedule(timerTask,2000,2*1000);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       try{

       }
       catch (Exception e){
           e.printStackTrace();
       }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
       try{
           mTimer.cancel();
           timerTask.cancel();
       }
       catch (Exception e){
           e.printStackTrace();
       }
        Intent intent= new Intent("com.machamasisuraj.socialapp");
       intent.putExtra("value","tourandtrek");
       sendBroadcast(intent);
    }

    public void notifyNow(){
        NotificationManagerCompat   notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel  createChannel = new CreateChannel(this);
        createChannel.createChannel();


        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("NotificationPull");

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        @SuppressLint("WrongConstant") PendingIntent pendingIntent= PendingIntent.getActivity(getBaseContext(),0,myIntent,Intent.FLAG_ACTIVITY_NEW_TASK);
        Context context= getApplicationContext();

        Notification.Builder builder;
        builder = new Notification.Builder(context)
                .setContentTitle("Tour and Trek")
                .setContentText("Tap Here")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_book_black_24dp);

        Notification notification= builder.build();
        notificationManagerCompat.notify(1,notification);


    }
}
