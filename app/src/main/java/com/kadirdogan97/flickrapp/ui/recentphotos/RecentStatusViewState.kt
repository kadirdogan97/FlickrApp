package com.kadirdogan97.flickrapp.ui.recentphotos

import com.kadirdogan97.flickrapp.common.Status

/**
 * Created by Kadir Doğan on 7/5/2020.
 */
class RecentStatusViewState(
    val status: Status
) {
    fun isLoading() = status is Status.Loading

    fun getErrorMessage() = if (status is Status.Error) status.exception.message else ""

    fun shouldShowErrorMessage() = status is Status.Error
}