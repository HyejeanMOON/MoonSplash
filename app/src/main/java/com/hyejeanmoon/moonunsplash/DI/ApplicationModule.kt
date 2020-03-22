package com.hyejeanmoon.moonunsplash.DI

import android.app.Application
import android.content.Context
import com.hyejeanmoon.moonunsplash.data.api.retrofit.ApiClientHelper
import com.hyejeanmoon.moonunsplash.data.api.retrofit.OkHttpClientSingleton
import com.hyejeanmoon.moonunsplash.data.scenes.photos.PhotoRemoteDataSourceImpl
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.service.PhotosApiService
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.model.PhotosModelImpl
import com.hyejeanmoon.moonunsplash.utils.EnvParameters
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ApiModule
 *
 * It's a Module of Dagger.
 * The effect of ApplicationModule will provide a instance of class automatically by dagger.
 */
@Module
class ApplicationModule {

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

    @Provides
    @Singleton
    internal fun provideOkHttpSingleton(): OkHttpClientSingleton {
        return OkHttpClientSingleton()
    }

    @Provides
    @Singleton
    internal fun providePhotosApiService(
        apiClientHelper: ApiClientHelper
    ): PhotosApiService {
        return ApiClientHelper.createPhotosApiService(
            apiClientHelper.baseUrl,
            OkHttpClientSingleton().plainOkHttpClient
        )
    }

    @Provides
    @Singleton
    internal fun providePhotoRemoteDataSource(
        photosApiService: PhotosApiService
    ): PhotoRemoteDataSource {
        return PhotoRemoteDataSourceImpl(photosApiService)
    }

    @Provides
    @Singleton
    internal fun providePhotosModel(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): PhotosModel {
        return PhotosModelImpl(photoRemoteDataSource)
    }
}