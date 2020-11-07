package com.nobel.dhar.offer.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nobel.dhar.offer.di.util.ViewModelKey
import com.nobel.dhar.offer.factory.AppViewModelFactory
import com.nobel.dhar.offer.ui.food_details.FoodDetailsViewModel
import com.nobel.dhar.offer.ui.home.FoodListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FoodListViewModel::class)
    abstract fun bindFoodListViewModel(foodListViewModel: FoodListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FoodDetailsViewModel::class)
    abstract fun bindFoodDetailsViewModel(foodDetailsViewModel: FoodDetailsViewModel): ViewModel

}