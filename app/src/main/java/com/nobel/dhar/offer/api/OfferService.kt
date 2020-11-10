package com.nobel.dhar.offer.api

import androidx.lifecycle.LiveData
import com.nobel.dhar.offer.persistence.FoodWithItems
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface OfferService {

    @GET("5fa96caabd01877eecdbb953/1")
    suspend fun fetchFoodList(@Header("secret-key") secretKey: String): Response<List<FoodWithItems>>
}