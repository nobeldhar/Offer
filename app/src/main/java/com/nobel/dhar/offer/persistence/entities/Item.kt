package com.nobel.dhar.offer.persistence.entities

import androidx.room.*
import com.nobel.dhar.offer.persistence.entities.Food

data class Item(
    val item_title: String,
    val item_number: String,
    val items_food_id: Int
) {

}