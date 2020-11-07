package com.nobel.dhar.offer.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.ui.home.CustomClickListener
import com.nobel.dhar.offer.ui.home.FoodListFragmentDirections
import dagger.android.support.DaggerAppCompatActivity

class OfferActivity : DaggerAppCompatActivity(), CustomClickListener,
    NavController.OnDestinationChangedListener {

    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer)
        navView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(this)
    }

    override fun onFoodSelected(food: Food) {
        val action = FoodListFragmentDirections.actionNavigationHomeToFoodDetailsFragment(food.food_id)
        navController.navigate(action)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when(destination.id){
            R.id.navigation_home -> navigationHome()
            R.id.navigation_dashboard -> navigationDashboard()
            R.id.navigation_notifications -> navigationNotification()
            R.id.navigation_food_details -> navigationFoodDetails()
        }
    }

    private fun navigationFoodDetails() {
        navViewVisibility(View.GONE)
    }

    private fun navigationNotification() {
        navViewVisibility(View.VISIBLE)
    }

    private fun navigationDashboard() {
        navViewVisibility(View.VISIBLE)
    }

    private fun navigationHome() {
        navViewVisibility(View.VISIBLE)
    }

    private fun navViewVisibility(visibility: Int) {
        navView.visibility = visibility
    }
}
