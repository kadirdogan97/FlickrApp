package com.kadirdogan97.flickrapp.common

import com.kadirdogan97.flickrapp.model.PhotoItem

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class Utils{
    companion object{
        fun convertPhotoItemToPhotoUrl(photoItem: PhotoItem): String =
            "https://farm${photoItem.farm}.staticflickr.com/${photoItem.server}/${photoItem.id}_${photoItem.secret}_b.jpg"

        fun convertPhotoItemToProfileImageUrl(photoItem: PhotoItem): String =
            "http://farm${photoItem.farm}.staticflickr.com/${photoItem.server}/buddyicons/${photoItem.owner}.jpg"

    }
}