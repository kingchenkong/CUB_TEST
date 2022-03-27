package com.example.cub_test._interface

import com.example.cub_test.model.json_data.GitHubUsersJSONItem

interface UserListContract {
    interface View {
        fun updateRecyclerView(list: List<GitHubUsersJSONItem>)
    }

    interface Presenter {
        suspend fun queryUsersList(): List<GitHubUsersJSONItem>?
    }
}