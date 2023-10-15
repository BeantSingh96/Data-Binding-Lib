package com.example.databinding.webService

import com.example.databinding.models.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("Accept: application/json")
    @GET("/api/Feed/GetNewsFeed")
    suspend fun getNewsList(): Response<NewsModel>
}