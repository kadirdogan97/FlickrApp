package com.kadirdogan97.flickrapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.kadirdogan97.flickrapp.R
import com.kadirdogan97.flickrapp.ui.recentphotos.VMRecentList
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: VMMain by viewModel()
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setNavController()
    }

    private fun setNavController() {
        navController = findNavController(R.id.nav_container)
//        viewModel.currentNavController = navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return viewModel.currentNavController?.value?.navigateUp() ?: false
//
//    }
}