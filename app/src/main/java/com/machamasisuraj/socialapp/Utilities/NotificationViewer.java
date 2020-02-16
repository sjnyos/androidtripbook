package com.machamasisuraj.socialapp.Utilities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.machamasisuraj.socialapp.GUI.BottomNavbarActivity;
import com.machamasisuraj.socialapp.GUI.LoginActivity;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Utilities.NotificationChannel.CreateChannel;

import static com.machamasisuraj.socialapp.Utilities.NotificationChannel.CreateChannel.Channel_2;


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
        Notification notification = new NotificationCompat.Builder(mContext, Channel_2)
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
                .setContentTitle(title)
                .setContentText(content)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);

    }
    public void DisplayPendingIntent(AppCompatActivity mContext){
        Intent notifyIntent = new Intent(mContext, LoginActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                mContext, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext,Channel_2)
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentTitle("Black box")
                .setContentText("this is the black box message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        builder.setContentIntent(notifyPendingIntent);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext);
        notificationManager.notify(3, builder.build());

    }
}
