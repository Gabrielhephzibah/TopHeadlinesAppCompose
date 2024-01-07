package com.example.topheadlinesappcompose.data.remote

import com.example.topheadlinesappcompose.data.remote.dto.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
   suspend fun getTopHeadlines(
        @Query("sources") sources: String,
        @Query("apiKey")apiKey:String
    ):TopHeadlinesResponse
}