package com.nobel.dhar.offer.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {

    suspend fun insertFoodWithItems(foodWithItemsList: List<FoodWithItems>) {
        for(i in foodWithItemsList){
            insertFood(i.food)
            insertItems(items = i.items)
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<Item>)

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