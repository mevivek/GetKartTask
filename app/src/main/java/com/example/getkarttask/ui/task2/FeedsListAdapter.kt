package com.example.getkarttask.ui.task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.getkarttask.R
import com.example.getkarttask.databinding.FeedBinding
import com.example.getkarttask.entities.Post
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class FeedsListAdapter : ListAdapter<Post, FeedsListAdapter.ViewHolder>(object :
    DiffUtil.ItemCallback<Post>() {

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem;
    }

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FeedBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val binding: FeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            Picasso.get().load(post.image).placeholder(R.drawable.loading)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(binding.root)
        }
    }
}