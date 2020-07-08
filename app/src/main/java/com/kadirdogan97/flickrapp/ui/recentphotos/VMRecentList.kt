package com.kadirdogan97.flickrapp.ui.recentphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.kadirdogan97.flickrapp.common.*
import com.kadirdogan97.flickrapp.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class VMRecentList(private val recentListUseCase: RecentListUseCase): ReactiveViewModel(){

    private val contents = SingleLiveEvent<List<PhotoItem>>()
    val contents_: LiveData<List<PhotoItem>> = contents

    private val status = MutableLiveData<RecentStatusViewState>()
    val status_: LiveData<RecentStatusViewState> = status

    fun fetchRecentPhotos(page: Int) {
        recentListUseCase
            .fetchRecentPhotos(page)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { list ->
                Log.d("VMRecentList",list.toString())
                onRecentPhotoContentResultReady(list)

            }
            .subscribe({ resource ->
                Log.d("VMRecentList",resource.toString())
                onRecentPhotoStatusResultReady(resource)
            }, {})
            .also { disposable.add(it) }
    }

    private fun onRecentPhotoContentResultReady(results: List<PhotoItem>) {
        contents.value = results
    }

    private fun onRecentPhotoStatusResultReady(resource: Resource<List<PhotoItem>>) {
        val viewState = when (resource) {
            is Resource.Success -> RecentStatusViewState(Status.Content)
            is Resource.Error -> RecentStatusViewState(Status.Error(resource.exception))
            Resource.Loading -> RecentStatusViewState(Status.Loading)
        }
        status.value = viewState
    }

}