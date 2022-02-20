package com.example.getkarttask.ui.task1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.getkarttask.R
import com.example.getkarttask.databinding.SuggestedBinding
import com.example.getkarttask.entities.User
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class UsersListAdapter : ListAdapter<User, UsersListAdapter.ViewHolder>(object :
    DiffUtil.ItemCallback<User>() {

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem;
    }

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SuggestedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val binding: SuggestedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            Picasso.get().load(user.picture).placeholder(R.drawable.loading)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(binding.image)
            binding.user = user
        }
    }
}