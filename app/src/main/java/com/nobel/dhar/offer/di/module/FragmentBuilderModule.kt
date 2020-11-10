package com.nobel.dhar.offer.di.module

import com.nobel.dhar.offer.ui.food_details.FoodDetailsFragment
import com.nobel.dhar.offer.ui.home.FoodListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFoodListFragment(): FoodListFragment

    @ContributesAndroidInjector
    abstract fun contributeFoodDetailFragment(): FoodDetailsFragment
}