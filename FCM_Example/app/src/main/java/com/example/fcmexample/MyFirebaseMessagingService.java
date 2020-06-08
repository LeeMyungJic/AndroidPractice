package com.example.fcmexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String s) {
        Log.d("FCM Log","Refreshed token:" + s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getNotification() != null) { // onMessageReceived메소드를 통해서 notification이 왔을경우
            Log.d("FCM Log","알림 메시지:"+ remoteMessage.getNotification().getBody()); // log찍고
            String messageBody = remoteMessage.getNotification().getBody();
            String messageTitle = remoteMessage.getNotification().getTitle();
            Intent intent = new Intent(this,MainActivity.class); // intent를
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // addFlag 메소드에 관해서는 부가적인 설명이 더필요
            // 일단은 intent를 통해 액티비티가 실행되는 순서를 조정이 가능한 메소드로 알고있자.
            // 자세한건 README에서
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
            // Notification으로 작업을 하는 중이여서, PendingIntent를 사용해 intent를 사용할 수 있도록 한다.
            String channelId = "Channel ID";
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            // Notification에서 작업
            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat.Builder(this,channelId)
                    .setSmallIcon(R.drawable.warning)
                    .setContentTitle(messageTitle)
                    .setContentText(messageBody)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String channelName = "Channel Name";
                NotificationChannel channel = new NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }
            notificationManager.notify(0,notificationBuilder.build());
        }
    }
}
