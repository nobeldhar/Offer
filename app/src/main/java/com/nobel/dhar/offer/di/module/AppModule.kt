package com.nobel.dhar.offer.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nobel.dhar.offer.api.OfferRemoteDataSource
import com.nobel.dhar.offer.api.OfferService
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodDao
import com.nobel.dhar.offer.persistence.FoodDatabase
import com.nobel.dhar.offer.persistence.Item
import com.nobel.dhar.offer.repositories.FoodRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Nullable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {

    lateinit var database: FoodDatabase
    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            CoroutineScope(Dispatchers.IO).launch {
                prePopulateDatabase()
            }
        }

    }

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): FoodDatabase {
        database = Room
            .databaseBuilder(application, FoodDatabase::class.java, "food_database")
            .addCallback(databaseCallback)
            .build()

        return database
    }

    @Provides
    @Singleton
    fun provideFoodDao(@NonNull database: FoodDatabase): FoodDao {
        return database.foodDao()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/b/")
            .addConverterFactory(GsonConverterFactory.create(gson))
/*
            .client(okHttpClient)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
*/
            .build()
    }

    @Provides
    @Singleton
    fun provideOfferService(retrofit: Retrofit): OfferService {
        return retrofit.create(OfferService::class.java)
    }

    @Provides
    @Singleton
    fun provideOfferRemoteDataSource(offerService: OfferService) = OfferRemoteDataSource(offerService)

    @Provides
    @Singleton
    fun provideFoodRepository(localDataSource: FoodDao, remoteDataSource: OfferRemoteDataSource) = FoodRepository(localDataSource,remoteDataSource)

    /*@Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }*/

    private suspend fun prePopulateDatabase() {
        /*var foodDao = database.foodDao()

        // Delete all content here.
        foodDao.deleteAllFoods()

        // Add sample words.
        var food1 = Food(
            1,
            "FREE RM 50.00 KFC Dinner Set in Hari Raya Puasa",
            "339 Deals",
            "kfc_dinner_6",
            "37",
            "4.83(32)",
            "While stock last",
            "Beyan Lepas, Penang, Malayasia",
            "Dine In Voucher"
        )

        foodDao.insertFood(food1)

        var item1 = Item(
            "Spicy Chicken",
            "15", 1
        )
        var item2 = Item(
            "Mash Potatoes",
            "3", 1
        )
        var item3 = Item(
            "Bread",
            "4", 1
        )
        var item4 = Item(
            "Bottled Drink",
            "1.5L", 1
        )
        var item5 = Item(
            "Large Fries",
            "1", 1
        )
        var item6 = Item(
            "Coleslaws",
            "3", 1
        )
        var item7 = Item(
            "Cookies",
            "4", 1
        )
        foodDao.insertItem(item1, item2, item3, item4, item5, item6, item7)*/


    }
}