package com.kadirdogan97.flickrapp.data.remote

import com.kadirdogan97.flickrapp.data.RecentResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
interface FlickrApiRestInterface {

    @GET("rest")
    fun fetchRecentPhoto(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String? = "25f2f3f82468d6aa28f2ee2cc0c14dbc",
        @Query("method") method: String? = "flickr.photos.getRecent",
        @Query("format") format: String? = "json",
        @Query("nojsoncallback") noJsonCallback: Int? = 1,
        @Query("per_page") perPage: Int? = 20
    ): Observable<RecentResponse>

}