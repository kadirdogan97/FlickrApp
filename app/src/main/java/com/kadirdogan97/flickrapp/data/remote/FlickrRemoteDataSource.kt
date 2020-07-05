package com.kadirdogan97.flickrapp.data.remote

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class FlickrRemoteDataSource(private val restInterface: FlickrApiRestInterface){
    fun fetchRecentPhotos(page: Int) = restInterface.fetchRecentPhoto(page)
}