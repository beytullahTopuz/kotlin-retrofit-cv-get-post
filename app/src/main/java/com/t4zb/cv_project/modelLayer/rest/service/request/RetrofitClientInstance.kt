package com.t4zb.cv_project.modelLayer.rest.service.request
import android.content.Context
import com.t4zb.cv_project.modelLayer.network.cache.CacheClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClientInstance {
    private var retrofit: Retrofit? = null

    fun buildRetrofit(context: Context): Retrofit? {

        val client = CacheClient.createCachedClient(context)
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}