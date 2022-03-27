package com.example.cub_test.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cub_test._interface.UserListContract
import com.example.cub_test.adapter.UsersListAdapter
import com.example.cub_test.databinding.ActivityMainBinding
import com.example.cub_test.model.json_data.GitHubUsersJSONItem
import com.example.cub_test.presenter.UserListPresenter

class MainActivity : AppCompatActivity(), UserListContract.View {
    val TAG: String = MainActivity::class.java.simpleName

    // binding
    private lateinit var binding: ActivityMainBinding

    // user list adapter
    private lateinit var usersListAdapter: UsersListAdapter

    // adapter item's listener
    private val userListItemListener: UsersListAdapter.ItemOnClickCallback =
        object : UsersListAdapter.ItemOnClickCallback {
            override fun onClick(
                position: Int,
                viewHolder: UsersListAdapter.ViewHolder,
                json: GitHubUsersJSONItem
            ) {
                // intent to detail
            }
        }

    // override
    override fun updateRecyclerView(list: List<GitHubUsersJSONItem>) {
        usersListAdapter.jsonList = list
        usersListAdapter.notifyDataSetChanged()
    }

    // lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            val userListPresenter = UserListPresenter()
            val jsonList = userListPresenter.queryUsersList()
            updateRecyclerView(jsonList)
        }

    }

    // init recycler view
    private fun initRecyclerView() {
        lifecycleScope.launchWhenCreated {
            usersListAdapter = UsersListAdapter(
                this@MainActivity, listOf(), userListItemListener
            )

            val linearLayoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            binding.rvList.layoutManager = linearLayoutManager
            binding.rvList.adapter = usersListAdapter
        }
    }

}