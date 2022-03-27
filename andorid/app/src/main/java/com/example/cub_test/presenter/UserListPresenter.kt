package com.example.cub_test.presenter

import com.example.cub_test._interface.UserListContract
import com.example.cub_test.model.UsersListFetcher
import com.example.cub_test.model.json_data.GitHubUsersJSON
import com.example.cub_test.model.json_data.GitHubUsersJSONItem

class UserListPresenter : UserListContract.Presenter {

    override suspend fun queryUsersList(): List<GitHubUsersJSONItem> {
        val jsonList: GitHubUsersJSON? = UsersListFetcher.fetchUsersList()

        return if (jsonList != null) {
            // limit : 100
            val limitCount = 100
            val limitedList = if (jsonList.count() >= 100) {
                jsonList.take(limitCount)
            } else {
                jsonList
            }
            limitedList
        } else {
            listOf()
        }
    }
}