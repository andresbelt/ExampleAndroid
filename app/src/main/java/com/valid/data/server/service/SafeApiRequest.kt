package com.valid.data.server.service

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {
    suspend fun <T : Any> processCall(call: suspend () -> Response<T>): T {

        val response = call.invoke()
        val message = StringBuilder()

        if (response.isSuccessful) {
            Log.d("hellohello", "safeapireqsucc+${response.body()} ")
            if (response.body() != null)
                return response.body()!!
            else throw ApiException(response.code().toString())

        } else {
            val error = response.errorBody()?.string()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                    //    Log.d("hellohello","safeapireqfail 00000+${response.code()} ")

                } catch (e: JSONException) {

                }

            }
            message.append("Error code ${response.code()}")
            Log.d("hellohello", "safeapireqfail 00000+${response.code()} ")
            throw ApiException(message.toString())
        }
    }


    class ApiException(message: String) : IOException(message)
}