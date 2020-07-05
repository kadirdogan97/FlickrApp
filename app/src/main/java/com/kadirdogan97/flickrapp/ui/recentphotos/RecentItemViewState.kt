package com.kadirdogan97.flickrapp.ui.recentphotos

import com.bumptech.glide.util.Util
import com.kadirdogan97.flickrapp.common.Utils
import com.kadirdogan97.flickrapp.model.PhotoItem

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class RecentItemViewState(private val photoItem: PhotoItem) {
    fun getImageUrl(): String = Utils.convertPhotoItemToPhotoUrl(photoItem)
    fun getTitle() = photoItem.title
}