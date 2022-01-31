package com.t4zb.cv_project.modelLayer.rest.service.repo

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.t4zb.cv_project.modelLayer.rest.service.api.GetCVEndpointAPI
import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.modelLayer.rest.service.request.RetrofitClientInstance
import com.t4zb.cv_project.util.showLogDebug
import com.t4zb.cv_project.util.showLogError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CvRepositorty(val app: Application) {

    val cvData = MutableLiveData<List<Cv>>()

    @WorkerThread
    fun callWebServiceCV(){
        val retrofit = RetrofitClientInstance.buildRetrofit(app.applicationContext)
        val service = retrofit!!.create(GetCVEndpointAPI::class.java)


        service.getAllCV().enqueue(object :
            Callback<List<Cv>> {
            override fun onResponse(
                call: Call<List<Cv>>,
                response: Response<List<Cv>>
            ) {
                if (response.isSuccessful) {
                    cvData.postValue(response!!.body())
                  //  showLogDebug(TAG,response!!.body().toString())
                }
            }

            override fun onFailure(call: Call<List<Cv>>, t: Throwable) {
           //     showLogError(TAG, t.printStackTrace().toString())
                showLogError(TAG,t.message.toString())
            }
        })

    }





    init {
        CoroutineScope(Dispatchers.IO).launch {
            callWebServiceCV()
        }
    }




    companion object{
        const val TAG = "CV Repository";
    }

}