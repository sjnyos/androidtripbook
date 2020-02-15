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

    private String title;
    private String content;

    public NotificationViewer(Context mContext, String title,String content){
        this.mContext=mContext;
        this.title=title;
        this.content=content;
        notificationManagerCompat = NotificationManagerCompat.from(mContext);
        createChannel = new CreateChannel(mContext);
        createChannel.createChannel();

    }


    public void ClassicDispplaynotification() {
        Notification notification = new NotificationCompat.Builder(mContext,CreateChannel.Channel_2)
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentTitle(title)
                .setContentText(content)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);


    }

    public void PopupDisplayNotification() {

        Notification notification = new NotificationCompat.Builder(mContext,CreateChannel.Channel_1)
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentTitle("Black box")
                .setContentText("this is the black box message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);

    }
}
