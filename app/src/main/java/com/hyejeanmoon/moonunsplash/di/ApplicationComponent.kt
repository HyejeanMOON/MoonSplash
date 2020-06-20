package com.hyejeanmoon.moonunsplash.di

import android.app.Application
import com.hyejeanmoon.AndroidApplication
import com.hyejeanmoon.moonunsplash.presentation.scenes.home.HomeActivityModule
import com.hyejeanmoon.moonunsplash.presentation.scenes.photo.PhotoActivityModule
import com.hyejeanmoon.moonunsplash.presentation.scenes.photolist.PhotoListActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        HomeActivityModule.Builder::class,
        ApplicationModule::class,
        PhotoActivityModule.Builder::class,
        PhotoListActivityModule.Builder::class
    ]
)
interface ApplicationComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(app: AndroidApplication)
}

internal fun Application.createApplicationComponent() =
    DaggerApplicationComponent.builder().application(this).build()
