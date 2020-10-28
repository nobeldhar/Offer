package com.nobel.dhar.offer.ui.food_details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nobel.dhar.offer.persistence.FoodDatabase
import com.nobel.dhar.offer.persistence.FoodWithItems
import com.nobel.dhar.offer.repositories.FoodRepository

class FoodDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FoodRepository
    init {
        val foodDao = FoodDatabase.getDatabase(application, viewModelScope).foodDao()
        repository = FoodRepository(foodDao)
    }

    fun getFoodById(food_id: Int) = repository.getFoodById(food_id)

}

