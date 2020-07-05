package com.kadirdogan97.flickrapp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

data class PhotoListResult(
    val page: Int?,
    val pages: Int?,
    val perpage: Int?,
    val photo: List<PhotoItem?>,
    val total: String?
)