package com.kadirdogan97.flickrapp.data

import com.kadirdogan97.flickrapp.common.Resource
import com.kadirdogan97.flickrapp.data.remote.FlickrRemoteDataSource
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class FlickrRepository(private val remoteDataSource: FlickrRemoteDataSource) {
    fun fetchRecentPhotos(page: Int): Observable<Resource<RecentResponse>> {
        return remoteDataSource
            .fetchRecentPhotos(page)
            .map<Resource<RecentResponse>> {
                Resource.Success(it)
            }.onErrorReturn { throwable ->
                Resource.Error(throwable)
            }.subscribeOn(Schedulers.io())
    }
}