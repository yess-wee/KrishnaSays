package com.yash.krishnasaysapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QuoteApi {

    @GET("slok/{chapter}/{verse}/")
    suspend fun getSlok(@Path("chapter") chapter: Int, @Path("verse") verse: Int): Response<QuoteModel>

}
