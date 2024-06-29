package com.yash.krishnasaysapp


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QuoteApi {

    @GET("slok/{chapter}/{verse}/")
    fun getSlok(@Path("chapter") chapter: Int, @Path("verse") verse: Int):  Response<List<QuoteModel>>

//
//    @GET("slok/{id}")
//    suspend fun getRandomQuote() : Response<List<QuoteModel>>
}