package com.example.cub_test._interface

interface UserListContract {
    interface View {
        fun updateRecyclerView()
    }

    interface Presenter {
        suspend fun queryUsersList()
    }
}