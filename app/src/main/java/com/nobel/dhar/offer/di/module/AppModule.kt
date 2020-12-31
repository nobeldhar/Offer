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
import com.nobel.dhar.offer.api.RequestInterceptor
import com.nobel.dhar.offer.persistence.daos.FoodDao
import com.nobel.dhar.offer.persistence.FoodDatabase
import com.nobel.dhar.offer.repositories.FoodRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {

    lateinit var database: FoodDatabase
    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            CoroutineScope(Dispatchers.IO).launch {
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
    fun provideOkHttpClient(
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        with(builder) {
            addInterceptor(requestInterceptor)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/b/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOfferService(retrofit: Retrofit): OfferService {
        return retrofit.create(OfferService::class.java)
    }





}