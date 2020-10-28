package com.nobel.dhar.offer.persistence

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(vararg item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Query("DELETE FROM food_table")
    suspend fun deleteAllFoods()

    @Transaction
    @Query("SELECT * from food_table")
    fun getFoods(): LiveData<List<FoodWithItems>?>

    @Transaction
    @Query("SELECT * FROM food_table WHERE food_id = :food_id")
    fun getFoodById(food_id: Int): LiveData<FoodWithItems>

}