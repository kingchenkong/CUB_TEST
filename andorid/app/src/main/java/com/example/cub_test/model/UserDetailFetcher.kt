package com.example.cub_test.model

import com.example.cub_test.model.api.GitHubApiService
import com.example.cub_test.model.json_data.GitHubUserDetailJSON
import com.google.gson.Gson
import com.google.gson.JsonArray

object UserDetailFetcher {

    @kotlin.jvm.Throws(IllegalArgumentException::class)
    suspend fun fetchUsersDetails(
        userName: String
    ): GitHubUserDetailJSON? {
        val responseBody = GitHubApiService.queryUsersDetail(userName)

        when {
            responseBody.isSuccess -> {
                val json = responseBody.getOrNull() ?: JsonArray()
                val gson = Gson()
                return gson.fromJson(json, GitHubUserDetailJSON::class.java)
            }
            else -> {
                val exception =
                    responseBody.exceptionOrNull() ?: IllegalArgumentException("Error: is fail")
                throw exception
            }
        }
    }

}