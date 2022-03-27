package com.example.cub_test.model.api

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    /**
     * 查詢 使用者列表資料
     */
    @GET(ApiConstants.USERS_LIST)
    suspend fun queryUsersList(): Response<JsonArray>

    /**
     * 查詢 使用者細節資料
     */
    @GET(ApiConstants.USERS_LIST + "/{userName}")
    suspend fun queryUserDetail(
        @Path("userName") userName: String,
    ): Response<JsonObject>

}