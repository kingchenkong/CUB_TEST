package com.example.cub_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.cub_test.R
import com.example.cub_test.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    val TAG: String = DetailActivity::class.java.simpleName


    private lateinit var binding: ActivityDetailBinding

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

    }

    // listener
    private fun setListener() {
        // back to user list
        binding.ivClose.setOnClickListener {
            finish()
        }
    }
    
}