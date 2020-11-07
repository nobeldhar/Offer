package com.nobel.dhar.offer.repositories

import androidx.lifecycle.LiveData
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodDao
import com.nobel.dhar.offer.persistence.FoodWithItems
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository @Inject constructor(private val foodDao: FoodDao) {

    val allFoods: LiveData<List<FoodWithItems>?> = foodDao.getFoods()
    fun getFoodById(food_id: Int) = foodDao.getFoodById(food_id)


}