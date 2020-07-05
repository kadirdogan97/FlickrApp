package com.kadirdogan97.flickrapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kadirdogan97.flickrapp.databinding.FragmentRecentDetailBinding
import com.kadirdogan97.flickrapp.databinding.FragmentRecentListBinding
import com.kadirdogan97.flickrapp.ui.recentphotos.RecentListAdapter
import com.kadirdogan97.flickrapp.ui.recentphotos.VMRecentList
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class RecentDetailFragment(): Fragment(){
    private lateinit var _binding: FragmentRecentDetailBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecentDetailBinding.inflate(inflater, container, false)
        getBundleArguments()


        return binding.root
    }

    private fun getBundleArguments() {
        arguments?.getString("PhotoUrlObject")?.let {
            binding.staticUrl = it
            binding.executePendingBindings()
        }
    }
}