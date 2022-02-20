package com.example.getkarttask.ui.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.getkarttask.databinding.FragmentClipsBinding
import com.example.getkarttask.databinding.FragmentFeedsBinding


class ClipsFragment : Fragment() {

    private var _binding: FragmentClipsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentClipsBinding.inflate(inflater, container, false)

        val feedsListAdapter = FeedsListAdapter()
        binding.clips.adapter = feedsListAdapter

        val viewModel = Task2ViewModel()
        viewModel.posts.observe(requireActivity()) {
            feedsListAdapter.submitList(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}