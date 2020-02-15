package com.machamasisuraj.socialapp.Utilities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.machamasisuraj.socialapp.GUI.MainActivity;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Utilities.CreateChannel.CreateChannel;

import static android.content.Context.NOTIFICATION_SERVICE;


public class NotificationViewer {
    private NotificationManagerCompat notificationManagerCompat;
    private Context mContext;
    CreateChannel createChannel;

    public NotificationViewer(Context mContext){
        this.mContext=mContext;

        notificationManagerCompat = NotificationManagerCompat.from(mContext);
        createChannel = new CreateChannel(mContext);
        createChannel.createChannel();

    }


    private void Dispplaynotification2() {
        Notification notification = new NotificationCompat.Builder(mContext,CreateChannel.Channel_2)
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentTitle("Android Message hehehe")
                .setContentText("this is the test messagte for android message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);


    }

    private void DisplayNotification() {

        Notification notification = new NotificationCompat.Builder(mContext,CreateChannel.Channel_1)
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentTitle("Black box")
                .setContentText("this is the black box message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);

    }
}
