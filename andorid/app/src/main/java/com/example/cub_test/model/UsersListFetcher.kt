package com.example.cub_test.model

import com.example.cub_test.model.api.GitHubApiService
import com.example.cub_test.model.json_data.GitHubUsersJSON
import com.google.gson.Gson
import com.google.gson.JsonArray

object UsersListFetcher {

    @kotlin.jvm.Throws(IllegalArgumentException::class)
    suspend fun fetchUsersList(): GitHubUsersJSON? {
        val responseBody = GitHubApiService.queryUsersList()

        when {
            responseBody.isSuccess -> {
                val json = responseBody.getOrNull() ?: JsonArray()
                val gson = Gson()
                return gson.fromJson(json, GitHubUsersJSON::class.java)
            }
            else -> {
                val exception =
                    responseBody.exceptionOrNull() ?: IllegalArgumentException("Error: is fail")
                throw exception
            }
        }
    }

}