package com.example.cub_test.presenter

import com.example.cub_test._interface.UserDetailContract
import com.example.cub_test.model.UserDetailFetcher
import com.example.cub_test.model.json_data.GitHubUserDetailJSON

class UserDetailPresenter : UserDetailContract.Presenter {

    override suspend fun queryUserDetail(jsonLogin: String): GitHubUserDetailJSON? {
        return UserDetailFetcher.fetchUsersDetails(jsonLogin)
    }
}