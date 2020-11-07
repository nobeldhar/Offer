package com.nobel.dhar.offer.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodDatabase
import com.nobel.dhar.offer.persistence.FoodWithItems
import com.nobel.dhar.offer.repositories.FoodRepository
import javax.inject.Inject

class FoodListViewModel@Inject constructor(private val repository: FoodRepository) : ViewModel() {


    val allFoods: LiveData<List<FoodWithItems>?>
    init {
        allFoods = repository.allFoods
    }
}