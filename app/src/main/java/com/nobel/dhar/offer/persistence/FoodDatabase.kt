package com.nobel.dhar.offer.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nobel.dhar.offer.persistence.converters.FoodConverter
import com.nobel.dhar.offer.persistence.daos.FoodDao
import com.nobel.dhar.offer.persistence.entities.Food
import com.nobel.dhar.offer.persistence.entities.Item

@Database(entities = [Food::class], version = 1, exportSchema = false)
@TypeConverters(value = [(FoodConverter::class)])
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

}