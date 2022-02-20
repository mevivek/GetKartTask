package com.example.getkarttask

import com.example.getkarttask.entities.Post
import com.example.getkarttask.entities.User
import retrofit2.http.GET

interface ApiService {

    @GET("post")
    suspend fun getPosts(): ApiResponse<List<Post>>

    @GET("user")
    suspend fun getUsers(): ApiResponse<List<User>>
}