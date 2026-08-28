package com.example.letras

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class LyricsListenerService : NotificationListenerService() {

    override fun onListenerConnected() {
        val notifications = activeNotifications
        if (notifications != null) {
            for (sbn in notifications) {
                processNotification(sbn)
            }
        }
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        processNotification(sbn)
    }

    private fun processNotification(sbn: StatusBarNotification) {
        val extras = sbn.notification.extras

        val title = extras.getCharSequence("android.title")?.toString() ?: ""
        val artist = extras.getCharSequence("android.text")?.toString() ?: ""
        val packageName = sbn.packageName

        if (packageName.contains("spotify") || packageName.contains("music") || sbn.notification.category == "transport") {
            if (title.isNotEmpty()) {
                Log.d("LETRAS_APP", "Tocando: $title - $artist")
                MusicState.updateMusic("$title\n$artist")
            }
        }
    }
}