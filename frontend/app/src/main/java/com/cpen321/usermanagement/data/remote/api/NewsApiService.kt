package com.cpen321.usermanagement.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

data class NewsResponse(
    val articles: List<Article>
)

data class Article(
    val title: String,
    val description: String?,
    val url: String,
)

interface NewsApiService {
    @GET("everything")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("searchIn") searchIn: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int = 5,
        @Query("language") language: String = "en"
    ): NewsResponse
}