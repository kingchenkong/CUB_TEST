package com.example.cub_test._interface

import com.example.cub_test.model.json_data.GitHubUserDetailJSON

interface UserDetailContract {
    interface View {
        fun updateView(json: GitHubUserDetailJSON)
    }

    interface Presenter {
        suspend fun queryUserDetail(jsonLogin: String): GitHubUserDetailJSON?
    }
}