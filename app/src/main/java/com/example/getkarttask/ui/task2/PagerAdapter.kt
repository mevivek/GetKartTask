package com.example.getkarttask.ui.task2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(private val fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FeedsFragment()
            1 -> ClipsFragment()
            2 -> TagsFragment()
            else -> ShareFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}