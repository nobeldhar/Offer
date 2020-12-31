package com.nobel.dhar.offer.ui.food_details

import androidx.lifecycle.ViewModel
import com.nobel.dhar.offer.data.repositories.FoodRepository
import javax.inject.Inject

class FoodDetailsViewModel
@Inject constructor(private val repository: FoodRepository)
    : ViewModel() {

    fun getFoodById(food_id: Int) = repository.getFoodById(food_id)

}

