package com.cpen321.usermanagement.data.repository

import com.cpen321.usermanagement.data.remote.api.Article
import com.cpen321.usermanagement.data.remote.api.NewsApiService
import com.cpen321.usermanagement.BuildConfig

import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getNewsForHobby(hobby: String): Result<List<Article>> = try {
        val res = newsApiService.getNews(hobby, searchIn = "title", BuildConfig.NEWS_API_KEY)
        Result.success(res.articles)
    } catch (e: Exception) {
        Result.failure(e)
    }
}