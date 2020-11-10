package com.nobel.dhar.offer.repositories

import androidx.lifecycle.LiveData
import com.nobel.dhar.offer.api.OfferRemoteDataSource
import com.nobel.dhar.offer.api.OfferService
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodDao
import com.nobel.dhar.offer.persistence.FoodWithItems
import com.nobel.dhar.offer.utils.performGetOperation
import javax.inject.Inject
import javax.inject.Singleton

class FoodRepository
@Inject constructor(
    private val localDataSource: FoodDao,
    private val remoteDataSource: OfferRemoteDataSource
) {


    fun getFoodList() = performGetOperation(
        databaseQuery = { localDataSource.getFoods() },
        networkCall = { remoteDataSource.getFoodList() },
        saveCallResult = { localDataSource.insertFoodWithItems(it) }
    )

    fun getFoodById(id: Int) = localDataSource.getFoodById(id)
}