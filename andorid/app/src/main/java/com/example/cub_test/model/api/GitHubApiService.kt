package com.example.cub_test.model.api

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubApiService {

    private val gitHubApi: GitHubApi

    init {
        val logInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
        val okHttpClient = OkHttpClient.Builder().addInterceptor(logInterceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.DO_MAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        gitHubApi = retrofit.create(GitHubApi::class.java)
    }


    /**
     * 查詢 使用者 列表
     */
    suspend fun queryUsersList(
    ): Result<JsonArray> {
        return kotlin.runCatching {
            val response = gitHubApi.queryUsersList()

            return@runCatching if (response.isSuccessful) {
                response.body()!!
            } else {
                val gson = Gson()
                val errorString = response.errorBody()!!.string()
                withContext(Dispatchers.Default) {
                    gson.fromJson(errorString, object : TypeToken<JsonObject>() {}.type)
                }
            }
        }
    }

    /**
     * 查詢 使用者 細節
     */
    suspend fun queryUsersDetail(
        userName: String
    ): Result<JsonObject> {
        return kotlin.runCatching {
            val response = gitHubApi.queryUserDetail(userName)

            return@runCatching if (response.isSuccessful) {
                response.body()!!
            } else {
                val gson = Gson()
                val errorString = response.errorBody()!!.string()
                withContext(Dispatchers.Default) {
                    gson.fromJson(errorString, object : TypeToken<JsonObject>() {}.type)
                }
            }
        }
    }

}