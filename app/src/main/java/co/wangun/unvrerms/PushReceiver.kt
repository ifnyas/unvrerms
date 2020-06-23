package co.wangun.unvrerms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PushReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val intent = Intent("erms")
        intent.putExtra("msg", 1)
        context.sendBroadcast(intent)
    }
}