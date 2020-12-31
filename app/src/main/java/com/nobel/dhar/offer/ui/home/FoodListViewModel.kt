package com.nobel.dhar.offer.ui.home

import androidx.lifecycle.*
import com.nobel.dhar.offer.repositories.FoodRepository
import javax.inject.Inject

class FoodListViewModel@Inject constructor(private val repository: FoodRepository) : ViewModel() {

    val allFoods = repository.getFoodList()
}