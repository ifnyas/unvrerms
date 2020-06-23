package co.wangun.unvrerms

import android.app.Activity
import android.os.AsyncTask
import me.pushy.sdk.Pushy

class RegisterForPushNotificationsAsync(private var mActivity: Activity) :
    AsyncTask<Void?, Void?, Any>() {

    override fun doInBackground(vararg p0: Void?) {
        try {
            Pushy.register(mActivity.applicationContext)
            Pushy.subscribe("erms", mActivity.applicationContext)
        } catch (e: Exception) {
        }
    }
}