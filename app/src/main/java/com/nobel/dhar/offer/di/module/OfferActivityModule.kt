package com.nobel.dhar.offer.di.module

import com.nobel.dhar.offer.ui.OfferActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Suppress("unused")
@Module
abstract class OfferActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): OfferActivity
}