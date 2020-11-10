package com.nobel.dhar.offer.di.component

import android.app.Application
import com.nobel.dhar.offer.OfferApp
import com.nobel.dhar.offer.di.module.AppModule
import com.nobel.dhar.offer.di.module.OfferActivityModule
import com.nobel.dhar.offer.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        OfferActivityModule::class
    ]
)

interface AppComponent : AndroidInjector<OfferApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}