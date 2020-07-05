package com.kadirdogan97.flickrapp.ui.recentphotos

import com.kadirdogan97.flickrapp.common.Resource
import com.kadirdogan97.flickrapp.common.map
import com.kadirdogan97.flickrapp.data.FlickrRepository
import com.kadirdogan97.flickrapp.model.PhotoItem
import io.reactivex.Observable

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class RecentListUseCase(private val repository: FlickrRepository, private val mapper: RecentListMapper){
    fun fetchRecentPhotos(page: Int): Observable<Resource<List<PhotoItem>>> {
        return repository
            .fetchRecentPhotos(page)
            .map { resource ->
                resource.map { response ->
                    mapper.mapFrom(response)
                }
            }.startWith(Resource.Loading)
    }
}