package com.nobel.dhar.offer.repositories

import com.nobel.dhar.offer.api.OfferRemoteDataSource
import com.nobel.dhar.offer.persistence.daos.FoodDao
import com.nobel.dhar.offer.utils.performGetOperation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository
@Inject constructor(
    private val localDataSource: FoodDao,
    private val remoteDataSource: OfferRemoteDataSource
) {


    fun getFoodList() = performGetOperation(
        databaseQuery = { localDataSource.getFoods() },
        networkCall = { remoteDataSource.getFoodList() },
        saveCallResult = { localDataSource.insertFoods(it) }
    )

    fun getFoodById(id: Int) = localDataSource.getFoodById(id)
}