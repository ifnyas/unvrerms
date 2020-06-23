package co.wangun.unvrerms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class WidgetReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        PostPush().execute()
    }
}