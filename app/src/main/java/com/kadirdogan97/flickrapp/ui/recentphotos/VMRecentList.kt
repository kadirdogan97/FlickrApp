package com.kadirdogan97.flickrapp.ui.recentphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kadirdogan97.flickrapp.common.ReactiveViewModel
import com.kadirdogan97.flickrapp.common.Resource
import com.kadirdogan97.flickrapp.common.Status
import com.kadirdogan97.flickrapp.common.doOnSuccess
import com.kadirdogan97.flickrapp.model.PhotoItem
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class VMRecentList(private val recentListUseCase: RecentListUseCase): ReactiveViewModel(){

    private val contents = MutableLiveData<List<PhotoItem>>()
    val contents_: LiveData<List<PhotoItem>> = contents

//    private val status = MutableLiveData<RecentPhotoStatusViewState>()
//    val status_: LiveData<RecentPhotoStatusViewState> = status

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
//                onRecentPhotoStatusResultReady(resource)
            }, {})
            .also { disposable.add(it) }
    }

    private fun onRecentPhotoContentResultReady(results: List<PhotoItem>) {
        contents.value = results
    }

//    private fun onRecentPhotoStatusResultReady(resource: Resource<List<PhotoItem>>) {
//
//        val viewState = when (resource) {
//            is Resource.Success -> Status.Content
//            is Resource.Error -> Status.Error(resource.exception)
//            Resource.Loading -> Status.Loading
//        }
//        status.value = viewState
//    }

}