package com.t4zb.cv_project.modelLayer.rest.service.api



import com.t4zb.cv_project.modelLayer.rest.service.event.Cv
import com.t4zb.cv_project.modelLayer.rest.service.event.Message

import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface GetCVEndpointAPI {

    @GET("api/cv")
    fun getAllCV(
    ): Call<List<Cv>>

    @Headers("Content-Type: application/json")
    @POST("api/cv")
    fun createCv(@Body requestBody: Cv): Call<Message>
}