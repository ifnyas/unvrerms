package co.wangun.unvrerms

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import kotlinx.android.synthetic.main.activity_main.*
import me.pushy.sdk.Pushy

class MainActivity : AppCompatActivity() {

    private lateinit var broadcastReceiver: BroadcastReceiver
    private var status = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFun()
    }

    private fun initFun() {
        pushyFun()
        registerReceiver()
        updateView()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver)
        }
    }

    private fun registerReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val statusReceived = intent.getIntExtra("msg", 1)
                status = if (status == 1) {
                    0
                } else {
                    statusReceived
                }
                updateView()
            }
        }
        registerReceiver(broadcastReceiver, IntentFilter("erms"))
    }

    private fun pushyFun() = runWithPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
        Pushy.listen(this)
        if (!Pushy.isRegistered(this)) {
            RegisterForPushNotificationsAsync(this).execute()
        }
    }

    private fun updateView() {
        if (status == 0) {
            lens.visibility = View.INVISIBLE
            position.text = ""
        } else {
            lens.visibility = View.VISIBLE
            position.text = "User Position: A1"
        }
    }

    private fun pushStatus() {
        //
    }
}