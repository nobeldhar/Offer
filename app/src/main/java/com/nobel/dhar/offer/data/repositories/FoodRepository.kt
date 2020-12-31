package com.nobel.dhar.offer.data.repositories

import com.nobel.dhar.offer.data.remote.OfferRemoteDataSource
import com.nobel.dhar.offer.data.local.daos.FoodDao
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