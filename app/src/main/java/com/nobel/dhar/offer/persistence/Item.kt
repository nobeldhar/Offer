package com.nobel.dhar.offer.persistence

import androidx.room.*

@Entity(tableName = "item_table",
    foreignKeys = [ForeignKey(entity = Food::class,
        parentColumns = ["food_id"],
        childColumns = ["items_food_id"],
        onDelete = ForeignKey.CASCADE
    )],indices = [Index(value = ["items_food_id"])])
data class Item(@PrimaryKey()
           @ColumnInfo(name = "item_title") val item_title: String,
           @ColumnInfo(name = "item_number") val item_number: String,
                @ColumnInfo(name = "items_food_id") val items_food_id: Int) {

}