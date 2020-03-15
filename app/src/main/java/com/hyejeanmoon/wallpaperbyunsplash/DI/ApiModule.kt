package com.hyejeanmoon.wallpaperbyunsplash.DI

import android.app.Application
import android.content.Context
import com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit.ApiClientHelper
import com.hyejeanmoon.wallpaperbyunsplash.utils.EnvParameters
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ApiModule
 *
 * It's a Module of Dagger.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideApiClientHelper(): ApiClientHelper {
        return ApiClientHelper(EnvParameters.BASE_URL)
    }
}