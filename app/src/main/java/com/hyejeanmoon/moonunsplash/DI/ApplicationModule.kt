package com.hyejeanmoon.moonunsplash.DI

import android.app.Application
import android.content.Context
import com.hyejeanmoon.moonunsplash.data.api.retrofit.ApiClientHelper
import com.hyejeanmoon.moonunsplash.data.api.retrofit.OkHttpClientSingleton
import com.hyejeanmoon.moonunsplash.data.scenes.collections.CollectionRemoteDataSourceImpl
import com.hyejeanmoon.moonunsplash.data.scenes.collections.CollectionsDataSourceFactory
import com.hyejeanmoon.moonunsplash.data.scenes.collections.service.CollectionsApiService
import com.hyejeanmoon.moonunsplash.data.scenes.photos.*
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.service.PhotosApiService
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
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
        photoRemoteDataSource: PhotoRemoteDataSource,
        latestPhotosDataSourceFactory: LatestPhotosDataSourceFactory,
        popularPhotosDataSourceFactory: PopularPhotosDataSourceFactory,
        oldestPhotosDataSourceFactory: OldestPhotosDataSourceFactory
    ): PhotosModel {
        return PhotosModelImpl(
            photoRemoteDataSource,
            latestPhotosDataSourceFactory,
            popularPhotosDataSourceFactory,
            oldestPhotosDataSourceFactory
        )
    }

    @Provides
    @Singleton
    internal fun providePopularPhotoDataSourceFactory(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): PopularPhotosDataSourceFactory {
        return PopularPhotosDataSourceFactory(
            photoRemoteDataSource,
            PhotosDataSource.MODE_PHOTO_LIST_POPULAR
        )
    }

    @Provides
    @Singleton
    internal fun provideLatestPhotoDataSourceFactory(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): LatestPhotosDataSourceFactory {
        return LatestPhotosDataSourceFactory(
            photoRemoteDataSource,
            PhotosDataSource.MODE_PHOTO_LIST_LATEST
        )
    }

    @Provides
    @Singleton
    internal fun provideOldestPhotoDataSourceFactory(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): OldestPhotosDataSourceFactory {
        return OldestPhotosDataSourceFactory(
            photoRemoteDataSource,
            PhotosDataSource.MODE_PHOTO_LIST_OLDEST
        )
    }

    @Provides
    @Singleton
    internal fun provideCollectionsDataSourceFactory(
        collectionsRemoteDataSource: CollectionsRemoteDataSource
    ): CollectionsDataSourceFactory {
        return CollectionsDataSourceFactory(collectionsRemoteDataSource)
    }

    @Provides
    @Singleton
    internal fun provideCollectionsRemoteDataSource(
        collectionsApiService: CollectionsApiService
    ): CollectionsRemoteDataSource {
        return CollectionRemoteDataSourceImpl(collectionsApiService)
    }
}