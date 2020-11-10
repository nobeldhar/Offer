package com.nobel.dhar.offer.api

import javax.inject.Inject

class OfferRemoteDataSource @Inject constructor(
    private val offerService: OfferService
): BaseDataSource() {
    suspend fun getFoodList() = getResult { offerService.fetchFoodList("\$2b\$10\$vB5gvOv/K/w3ShFEsMwgi.8jH35CLT398iFNwZ1Gu5ELNXcQHbhQO") }
}