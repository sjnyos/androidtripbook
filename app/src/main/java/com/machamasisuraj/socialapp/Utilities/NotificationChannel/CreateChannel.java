package com.machamasisuraj.socialapp.Utilities.NotificationChannel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;
    public final  static String Channel_1="channel 1";
    public final static  String Channel_2="channel 2";

    public CreateChannel(Context context) {
        this.context = context;
    }

    public void createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    Channel_1,
                    "CreateChannel Name 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription(("this is CreateChannel 1"));
            NotificationChannel channel2 = new NotificationChannel(
                    Channel_2,
                    "CreateChannel Name 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("this is channel 2");
            NotificationManager manager= context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
