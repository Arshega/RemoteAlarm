package com.example.pc.remotealarm

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.KeyguardManager
import android.media.AudioManager





class SmsServ: FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage?) {
        val intent: Intent = Intent(this@SmsServ, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)


        val pi: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val ncb: NotificationCompat.Builder = NotificationCompat.Builder(this)
        val defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        ncb.setContentTitle("FCM NOTIFICATION")
        ncb.setContentText(p0?.notification?.body)
        ncb.setAutoCancel(true)
        ncb.setSmallIcon(R.mipmap.ic_launcher)
        ncb.priority = NotificationCompat.PRIORITY_MAX
        ncb.setSound(defaultSound)
        ncb.setPriority(NotificationCompat.PRIORITY_HIGH)
        ncb.setVibrate(longArrayOf(500, 5000))
        ncb.setContentIntent(pi)


        val nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.notify(0, ncb.build())
    }
}