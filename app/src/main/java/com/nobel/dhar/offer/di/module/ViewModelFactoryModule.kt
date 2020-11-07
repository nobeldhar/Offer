package com.nobel.dhar.offer.di.module

import androidx.lifecycle.ViewModelProvider
import com.nobel.dhar.offer.factory.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}