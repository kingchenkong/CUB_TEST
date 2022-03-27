package com.example.cub_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cub_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName

    // binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()


    }
}