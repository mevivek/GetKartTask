package com.example.getkarttask.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getkarttask.databinding.ActivityMainBinding
import com.example.getkarttask.ui.task1.Task1Activity
import com.example.getkarttask.ui.task2.Task2Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.task1.setOnClickListener {
            startActivity(Intent(this, Task1Activity::class.java))
        }

        binding.task2.setOnClickListener {
            startActivity(Intent(this, Task2Activity::class.java))
        }
    }
}