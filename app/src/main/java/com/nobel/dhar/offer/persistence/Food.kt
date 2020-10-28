package com.nobel.dhar.offer.persistence

import android.widget.ImageView
import androidx.databinding.BindingAdapter
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
    val image: Int,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "offer_until")
    val offer_until: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "restaurant")
    val restaurant: String
){

}

