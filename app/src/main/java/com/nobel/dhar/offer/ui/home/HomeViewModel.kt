package com.nobel.dhar.offer.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodDatabase
import com.nobel.dhar.offer.persistence.FoodWithItems
import com.nobel.dhar.offer.repositories.FoodRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FoodRepository
    val allFoods: LiveData<List<FoodWithItems>?>
    init {
        val foodDao = FoodDatabase.getDatabase(application, viewModelScope).foodDao()
        repository = FoodRepository(foodDao)
        allFoods = repository.allFoods
    }
}