package com.example.getkarttask.ui.task2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getkarttask.R
import com.example.getkarttask.databinding.ActivityTask2Binding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

class Task2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTask2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Feeds";
                    tab.icon = getDrawable(R.drawable.ic_round_apps_24)
                }
                1 -> {
                    tab.text = "Clips"
                    tab.icon = getDrawable(R.drawable.ic_round_music_video_24)
                }
                2 -> {
                    tab.text = "Tags"
                    tab.icon = getDrawable(R.drawable.ic_round_alternate_email_24)
                }
                3 -> {
                    tab.text = "Share"
                    tab.icon = getDrawable(R.drawable.ic_round_send_24)
                }

            }

        }.attach()

        var isShow = true
        var scrollRange = -1
        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (scrollRange == -1) {
                scrollRange = appBarLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0) {
                binding.toolbar.apply {
                    title = "Naresh Sharma"
                    setNavigationIconTint(Color.WHITE)
                }
                isShow = true
            } else if (isShow) {
                binding.toolbar.apply {
                    title = " "
                    setNavigationIconTint(Color.BLACK)
                }
                isShow = false
            }
        })
    }
}