package com.example.getkarttask.ui.task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getkarttask.databinding.ActivityTask1Binding

class Task1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTask1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        val usersListAdapter = UsersListAdapter()

        binding.users.adapter = usersListAdapter

        val viewModel = Task1ViewModel()

        viewModel.users.observe(this) { users ->
            usersListAdapter.submitList(users)
        }
    }
}