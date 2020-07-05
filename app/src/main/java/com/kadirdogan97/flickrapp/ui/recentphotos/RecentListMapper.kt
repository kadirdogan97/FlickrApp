package com.kadirdogan97.flickrapp.ui.recentphotos

import com.kadirdogan97.flickrapp.common.Mapper
import com.kadirdogan97.flickrapp.data.RecentResponse
import com.kadirdogan97.flickrapp.model.PhotoItem

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class RecentListMapper(): Mapper<RecentResponse, List<PhotoItem>>{
    override fun mapFrom(type: RecentResponse): List<PhotoItem> {
        return type.photos?.photo!!.map { itemResponse ->
            PhotoItem(
                farm = itemResponse?.farm,
                id = itemResponse?.id,
                isfamily = itemResponse?.isfamily,
                isfriend = itemResponse?.isfriend,
                ispublic = itemResponse?.ispublic,
                owner = itemResponse?.owner,
                secret = itemResponse?.secret,
                server = itemResponse?.server,
                title = itemResponse?.title
            )
        }
    }
}