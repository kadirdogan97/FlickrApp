package com.kadirdogan97.flickrapp.model

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

data class PhotoItem(
    val farm: Int?,
    val id: String?,
    val isfamily: Int?,
    val isfriend: Int?,
    val ispublic: Int?,
    val owner: String?,
    val secret: String?,
    val server: String?,
    val title: String?
)