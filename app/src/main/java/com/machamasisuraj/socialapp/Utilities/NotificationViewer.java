package com.machamasisuraj.socialapp.Utilities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.machamasisuraj.socialapp.GUI.MainActivity;
import com.machamasisuraj.socialapp.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationViewer {
    private Context mContext;
    public NotificationViewer(Context mContext){
        this.mContext=mContext;

    }

    NotificationCompat.Builder builder =
            new NotificationCompat.Builder(mContext)
                    .setSmallIcon(R.drawable.abc)
                    .setContentTitle("Notifications Example")
                    .setContentText("This is a test notification");

    Intent notificationIntent = new Intent(mContext, MainActivity.class);
    PendingIntent contentIntent = PendingIntent.getActivity(mContext, 0, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);
      builder.setContentIntent(contentIntent);

    // Add as notification
    NotificationViewer manager = (NotificationViewer) mContext.getSystemService(NOTIFICATION_SERVICE);
      manager.notify(0, builder.build());
}
