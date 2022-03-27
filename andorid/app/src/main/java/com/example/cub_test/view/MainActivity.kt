package com.example.cub_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.cub_test._interface.UserListContract
import com.example.cub_test.databinding.ActivityMainBinding
import com.example.cub_test.presenter.UserListPresenter

class MainActivity : AppCompatActivity(), UserListContract.View {
    val TAG: String = MainActivity::class.java.simpleName

    // binding
    private lateinit var binding: ActivityMainBinding

    // override
    override fun updateRecyclerView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            val userListPresenter = UserListPresenter()
            val jsonList = userListPresenter.queryUsersList()
            Log.e(TAG, "onStart: json: $jsonList")
            updateRecyclerView()
        }

    }

}