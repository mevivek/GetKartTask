package com.example.getkarttask.ui.task1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getkarttask.RetrofitHelper
import com.example.getkarttask.entities.Post
import com.example.getkarttask.entities.User
import kotlinx.coroutines.launch

class Task1ViewModel : ViewModel() {

    private val apiService = RetrofitHelper.getApiService()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        viewModelScope.launch {
            try {
                _users.value = apiService.getUsers().data!!
            } catch (e: Exception) {
                Log.e("posts error", e.message ?: "")
            }
        }
    }
}