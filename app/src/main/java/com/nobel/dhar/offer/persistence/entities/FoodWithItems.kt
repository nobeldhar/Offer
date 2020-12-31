package com.nobel.dhar.offer.persistence.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.nobel.dhar.offer.persistence.entities.Food
import com.nobel.dhar.offer.persistence.entities.Item

data class FoodWithItems(
    val food: Food,
    val items: List<Item>) {
}