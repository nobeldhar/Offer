package com.nobel.dhar.offer.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
class Food(
    @PrimaryKey()
    @ColumnInfo(name = "food_id")
    val food_id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "availability")
    val availability: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "offer_until")
    val offer_until: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "restaurant")
    val restaurant: String,
    @ColumnInfo(name = "offer")
    val offer: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "offer_image")
    val offer_image: String,
    @ColumnInfo(name = "items")
    val items: List<Item>
){

}

