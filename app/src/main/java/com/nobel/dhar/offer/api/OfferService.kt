package com.nobel.dhar.offer.api

import com.nobel.dhar.offer.persistence.entities.Food
import com.nobel.dhar.offer.persistence.entities.FoodWithItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface OfferService {

    @GET("5fa96caabd01877eecdbb953/3")
    suspend fun fetchFoodList():
            Response<List<Food>>
}