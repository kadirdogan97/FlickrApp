package com.kadirdogan97.flickrapp.data

import com.google.gson.annotations.SerializedName
import com.kadirdogan97.flickrapp.model.PhotoListResult

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
data class RecentResponse(
    val photos: PhotoListResult?,
    val stat: String?
)