package com.kadirdogan97.flickrapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

/**
 * Created by Kadir Doğan on 7/5/2020.
 */

class VMMain: ViewModel(){
    var currentNavController: LiveData<NavController>? = null

}