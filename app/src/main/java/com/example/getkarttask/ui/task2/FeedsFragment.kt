package com.example.getkarttask.ui.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.getkarttask.databinding.FragmentFeedsBinding


class FeedsFragment : Fragment() {

    private var _binding: FragmentFeedsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFeedsBinding.inflate(inflater, container, false)

        val feedsListAdapter = FeedsListAdapter()
        binding.feeds.adapter = feedsListAdapter

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