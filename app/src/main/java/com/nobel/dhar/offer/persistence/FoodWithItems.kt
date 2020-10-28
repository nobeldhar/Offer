package com.nobel.dhar.offer.persistence

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Relation

data class FoodWithItems(
    @Embedded val food: Food,
    @Relation( parentColumn = "food_id", entityColumn = "items_food_id")
    val items: List<Item>) {
}