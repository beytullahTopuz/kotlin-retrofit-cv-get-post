package com.t4zb.cv_project.modelLayer.rest.service.repo


import android.content.Context
import android.nfc.Tag
import androidx.annotation.WorkerThread
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.RequestBody
import com.t4zb.cv_project.modelLayer.rest.service.api.GetCVEndpointAPI
import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.modelLayer.rest.service.event.Message
import com.t4zb.cv_project.modelLayer.rest.service.request.RetrofitClientInstance
import com.t4zb.cv_project.util.showLogDebug
import com.t4zb.cv_project.util.showLogError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostCvApi(val context: Context, data: Cv) {


    var body = data

    @WorkerThread
    fun postWebServiceCV() {
        val retrofit = RetrofitClientInstance.buildRetrofit(context)
        val service = retrofit!!.create(GetCVEndpointAPI::class.java)

        //  val mjson: MediaType = MediaType.parse("application/json; charset=utf-8")

        //   val body: RequestBody = RequestBody.create(mjson,jsonObjectString)


        service.createCv(body).enqueue(object :
            Callback<Message> {
            override fun onFailure(call: Call<Message>, t: Throwable) {

                showLogError(TAG,"hataa : ${t.message}")
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
             if (response.isSuccessful){
                 showLogDebug(TAG,"kayıt başarılı : ${response!!.body()}")
             }
            }
        })


    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            postWebServiceCV()
        }
    }

    companion object {
        const val TAG = "POST API"
    }

}