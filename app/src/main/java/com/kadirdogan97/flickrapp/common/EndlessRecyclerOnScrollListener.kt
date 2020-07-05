package com.kadirdogan97.flickrapp.common

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerOnScrollListener() : RecyclerView.OnScrollListener() {

    // The total number of items in the dataset after the last load
    private var previousTotal: Int = 0
    var isLoading = true
    private var firstVisibleItem: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var numberThreshold: Int = 8
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        visibleItemCount = recyclerView.childCount
        totalItemCount = recyclerView.layoutManager?.itemCount ?: 0
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> {
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
            }
            is GridLayoutManager -> {
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
            }
            else -> {
                Exception("Unsupported LayoutManage")
            }
        }

        if (isLoading) {
            stateLoading()
        }

        if (isLoading.not()
            && totalItemCount - visibleItemCount <= firstVisibleItem + numberThreshold
        ) {
            onLoadMore()
            isLoading = true
        }
    }

    // check load more is success
    private fun stateLoading() {
        if (totalItemCount > previousTotal) {
            isLoading = false
            previousTotal = totalItemCount
        }
    }

    fun resetOnLoadMore() {
        firstVisibleItem = 0
        visibleItemCount = 0
        totalItemCount = 0
        previousTotal = 0
        isLoading = true
    }

    abstract fun onLoadMore()
}