package com.example.projectfoodpedia

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.fragment)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.favouritesFragment, R.id.homeFragment, R.id.profileFragment
        ).build()
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)

        //cara menentukan bottom navbar ada di fragment mana aja
        navController.addOnDestinationChangedListener{ _, nd: NavDestination, _ ->
            when(nd.id){
                R.id.favouriteDetailFragment,
                R.id.foodDetailsFragment,
                R.id.menuFragment -> navView.visibility = View.GONE
                else -> navView.visibility = View.VISIBLE
            }
        }
    }

    //cara mengaktifkan tombol back
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}