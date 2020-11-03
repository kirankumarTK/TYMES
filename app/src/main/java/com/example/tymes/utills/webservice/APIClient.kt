package com.example.tymes.utills.webservice

import androidx.collection.ArrayMap
import com.example.tymes.model.LoginModel
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface APIClient {

    @FormUrlEncoded
    @POST
    fun callLogin(
        @Url url: String,
        @FieldMap postParams: ArrayMap<String, Any>
    ): Response<LoginModel>
}