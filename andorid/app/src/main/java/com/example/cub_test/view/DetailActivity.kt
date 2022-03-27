package com.example.cub_test.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
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
        lifecycleScope.launchWhenStarted {
            json.let {
                // download avatar
                Glide.with(this@DetailActivity)
                    .load(it.avatar_url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .circleCrop()
                    .into(binding.ivAvatar)
                // user name
                binding.tvUserName.text = it.name
                // bio
                binding.tvBio.text = it.bio
                // login
                binding.tvLogin.text = it.login
                // location (nullable)
                binding.tvLocation.text = it.location // if null: blank
                // link: blog
                binding.tvLink.text = it.blog
                // site admin
                binding.tvAdmin.visibility = if (it.site_admin) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

                // set color
                val tint: Int =
                    ContextCompat.getColor(this@DetailActivity, R.color.detail_text)
                binding.ivClose.drawable.setTint(tint)
                binding.ivLogin.drawable.setTint(tint)
                binding.ivLocation.drawable.setTint(tint)
                binding.ivLink.drawable.setTint(tint)
            }
        }
    }

    override fun showErrorAlert() {
        val builder = AlertDialog.Builder(this@DetailActivity)
        builder.setTitle("系統訊息")
        builder.setMessage("無法取得 使用者細節資料")
        builder.setNegativeButton(
            "離開"
        ) { _: DialogInterface?, _: Int -> finish() }
        builder.create().show()
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
                    showErrorAlert()
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