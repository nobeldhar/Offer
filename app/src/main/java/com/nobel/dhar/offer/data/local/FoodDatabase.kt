package com.nobel.dhar.offer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nobel.dhar.offer.data.local.converters.FoodConverter
import com.nobel.dhar.offer.data.local.daos.FoodDao
import com.nobel.dhar.offer.data.local.entities.Food

@Database(entities = [Food::class], version = 1, exportSchema = false)
@TypeConverters(value = [(FoodConverter::class)])
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

}