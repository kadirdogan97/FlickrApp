package com.kadirdogan97.flickrapp.ui.recentphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kadirdogan97.flickrapp.common.EndlessScrollListener
import com.kadirdogan97.flickrapp.common.observeNonNull
import com.kadirdogan97.flickrapp.databinding.FragmentRecentListBinding
import com.kadirdogan97.flickrapp.model.PhotoItem
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class RecentListFragment: Fragment(){
    private val viewModel: VMRecentList by viewModel()
    private var recentListAdapter = RecentListAdapter().apply { }

    private lateinit var _binding: FragmentRecentListBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecentListBinding.inflate(inflater, container, false)
        observeAll()
        fetchRecentPhotos(1)
        initPopularTVShowsRecyclerView()
        return binding.root
    }


    private fun observeAll(){
        viewModel.contents_.observeNonNull(this){
            renderRecents(it)
        }

    }

    private fun initPopularTVShowsRecyclerView() {
        val gridLayoutManager = GridLayoutManager(context,2)
        binding.recyclerView.apply {
            adapter = recentListAdapter
            layoutManager = gridLayoutManager
            addOnScrollListener(object : EndlessScrollListener(gridLayoutManager) {
                override fun onLoadMore(page: Int) {
                    fetchRecentPhotos(page)
                }
            })
        }
    }
    private fun fetchRecentPhotos(page: Int) {
        viewModel.fetchRecentPhotos(page)
    }
    private fun renderRecents(contents: List<PhotoItem>) {
        recentListAdapter.setRecentPhoto(contents)
    }

}