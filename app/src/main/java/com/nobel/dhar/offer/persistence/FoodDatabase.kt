package com.nobel.dhar.offer.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nobel.dhar.offer.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Food::class, Item::class], version = 1, exportSchema = false)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    private class FoodDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var foodDao = database.foodDao()

                    // Delete all content here.
                    foodDao.deleteAllFoods()

                    // Add sample words.
                    var food1 = Food(1,
                        "FREE RM 50.00 KFC Dinner Set in Hari Raya Puasa",
                        "339 Deals",
                        R.drawable.kfc_dinner_6,
                        "37",
                        "4.83(32)",
                        "While stock last",
                        "Beyan Lepas, Penang, Malayasia",
                        "Dine In Voucher")

                    foodDao.insertFood(food1)

                    var item1 = Item("Spicy Chicken",
                        "15", 1)
                    var item2 = Item("Mash Potatoes",
                        "3", 1)
                    var item3 = Item("Bread",
                        "4", 1)
                    var item4 = Item("Bottled Drink",
                        "1.5L", 1)
                    var item5 = Item("Large Fries",
                        "1", 1)
                    var item6 = Item("Coleslaws",
                        "3", 1)
                    var item7 = Item("Cookies",
                        "4", 1)
                    foodDao.insertItem(item1, item2, item3, item4, item5, item6, item7)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): FoodDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "food_database"
                )
                    .addCallback(FoodDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}