package com.example.getkarttask.ui.task2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getkarttask.RetrofitHelper
import com.example.getkarttask.entities.Post
import kotlinx.coroutines.launch

class Task2ViewModel : ViewModel() {

    private val apiService = RetrofitHelper.getApiService()

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        viewModelScope.launch {
            try {
                _posts.value = apiService.getPosts().data!!
            } catch (e: Exception) {
                Log.e("posts error", e.message ?: "")
            }
        }
    }
}