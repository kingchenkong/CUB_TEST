package com.example.cub_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.cub_test.R
import com.example.cub_test._interface.UserDetailContract
import com.example.cub_test.databinding.ActivityDetailBinding
import com.example.cub_test.model.json_data.GitHubUserDetailJSON
import com.example.cub_test.model.json_data.GitHubUsersJSONItem
import com.example.cub_test.presenter.UserDetailPresenter

class DetailActivity : AppCompatActivity(), UserDetailContract.View {
    val TAG: String = DetailActivity::class.java.simpleName

    private lateinit var binding: ActivityDetailBinding

    // override
    override fun updateView(json: GitHubUserDetailJSON) {
        Log.e(TAG, "updateView: json: $json")

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // init method
        processIntent()
        setListener()

    }

    // init method
    private fun processIntent() {
        val extras = intent.extras
        val json: GitHubUsersJSONItem? = extras?.getSerializable("json") as GitHubUsersJSONItem?
        json!!.let {
            lifecycleScope.launchWhenStarted {
                val presenter = UserDetailPresenter()
                val detailJson = presenter.queryUserDetail(json.login)
                if (detailJson == null) {
                    Log.e(TAG, "processIntent: detailJson == null")
                } else {
                    updateView(detailJson)
                }
            }
        }
    }

    // listener
    private fun setListener() {
        // back to user list
        binding.ivClose.setOnClickListener {
            finish()
        }
    }


}