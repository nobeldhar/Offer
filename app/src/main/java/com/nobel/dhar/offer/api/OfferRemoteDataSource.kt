package com.nobel.dhar.offer.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferRemoteDataSource @Inject constructor(
    private val offerService: OfferService
): BaseDataSource() {
    suspend fun getFoodList() = getResult { offerService.fetchFoodList() }
}