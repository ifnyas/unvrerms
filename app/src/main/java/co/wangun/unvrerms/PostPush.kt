package co.wangun.unvrerms

import android.os.AsyncTask
import co.wangun.unvrerms.api.ApiClient
import co.wangun.unvrerms.api.ApiService
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostPush : AsyncTask<Void?, Void?, Any>() {

    override fun doInBackground(vararg p0: Void?) {
        try {
            val mApiService = ApiClient.pushyClient.create(ApiService::class.java)
            val contentType = "application/json"
            var msg = JsonObject()
            msg.addProperty("msg", "1")
            var data = JsonObject()
            data.add("data", msg)
            data.add("notification", JsonObject())
            data.addProperty("to", "/topics/erms")

            mApiService.push(contentType, data)
                .enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.isSuccessful) {
                            try {
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}