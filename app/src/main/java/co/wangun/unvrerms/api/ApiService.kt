package co.wangun.unvrerms.api

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("push?api_key=6b87f6b2bc0e49c3457d60710926e111bb54e2205f2bf99d600affefc6a60aed")
    fun push(
        @Header("Content-Type") contentType: String,
        @Body payload: JsonObject
    ): Call<ResponseBody>
}