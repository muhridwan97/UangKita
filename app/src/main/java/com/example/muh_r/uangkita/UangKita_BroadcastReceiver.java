package com.example.muh_r.uangkita;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class UangKita_BroadcastReceiver extends BroadcastReceiver {
    private NotificationCompat.Builder mNotifyBuilder;
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        mNotifyManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotifyBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(notificationPendingIntent)
                .addAction(R.drawable.ic_launcher_background,
                        "Niotifikasi ",
                        notificationPendingIntent);
        Notification myNotification = mNotifyBuilder.build();
        mNotifyManager.notify(NOTIFICATION_ID,  myNotification);
    }
}
