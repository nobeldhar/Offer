package com.nobel.dhar.offer.data.remote

import com.nobel.dhar.offer.data.local.entities.Food
import retrofit2.Response
import retrofit2.http.GET

interface OfferService {

    @GET("5fa96caabd01877eecdbb953/3")
    suspend fun fetchFoodList():
            Response<List<Food>>
}