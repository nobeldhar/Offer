package com.nobel.dhar.offer.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nobel.dhar.offer.data.local.entities.Food

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoods(foods: List<Food>)

    @Query("DELETE FROM food_table")
    suspend fun deleteAllFoods()

    @Query("SELECT * from food_table")
    fun getFoods(): LiveData<List<Food>>

    @Query("SELECT * FROM food_table WHERE food_id = :food_id")
    fun getFoodById(food_id: Int): LiveData<Food>

}