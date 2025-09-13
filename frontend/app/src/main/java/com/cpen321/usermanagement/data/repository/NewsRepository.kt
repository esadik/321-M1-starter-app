package com.cpen321.usermanagement.data.repository

import com.cpen321.usermanagement.data.remote.api.Article

interface NewsRepository {
    suspend fun getNewsForHobby(hobby: String): Result<List<Article>>
}