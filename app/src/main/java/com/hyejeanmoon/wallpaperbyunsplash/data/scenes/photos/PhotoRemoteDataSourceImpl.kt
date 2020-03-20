package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos

import com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit.ApiEnqueueCallback
import com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity.PhotoItem
import com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.service.PhotosApiService
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * PhotosRemoteDateSourceImpl
 *
 * It's implementation of Photos' remote data source.
 */
@Singleton
class PhotoRemoteDataSourceImpl(
    private val photosApiService: PhotosApiService
) : PhotoRemoteDataSource {

    override suspend fun getPhoto(id: String): PhotoItem = suspendCoroutine {

        photosApiService.getPhoto(id).enqueue(ApiEnqueueCallback({ response ->
            it.resume(response)
        }, { exception ->
            it.resumeWithException(exception)
        }))
    }

    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem> =
        suspendCoroutine {

            photosApiService.getPhotos(page, perPage, orderBy).enqueue(
                ApiEnqueueCallback({ response ->
                    it.resume(response)
                }, { exception ->
                    it.resumeWithException(exception)

                })
            )
        }

    override suspend fun getRandomPhoto(): PhotoItem = suspendCoroutine {

        photosApiService.getRandomPhoto()
            .enqueue(ApiEnqueueCallback({ response ->
                it.resume(response)
            }, { exception ->
                it.resumeWithException(exception)
            }))
    }

    override suspend fun getRandomPhotos(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<PhotoItem> = suspendCoroutine {

        photosApiService.getRandomPhotos(collections, featured, userName, query, orientation, count)
            .enqueue(ApiEnqueueCallback({ response ->
                it.resume(response)
            }, { exception ->
                it.resumeWithException(exception)
            }))
    }

}