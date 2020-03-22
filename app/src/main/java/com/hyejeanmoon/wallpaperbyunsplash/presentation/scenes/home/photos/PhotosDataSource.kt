package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home.photos

import androidx.paging.PageKeyedDataSource
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PhotosDataSource(
    private val model: PhotosModel,
    private val mode: String
) :
    PageKeyedDataSource<Int, Photo>(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        // Because of the number of photos is 3 times [per_page] when first time is loaded. So, we will set next page is 4, not 2.
        when (mode) {
            MODE_PHOTO_LIST_LATEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithLatest(1, params.requestedLoadSize),
                        null,
                        4
                    )
                }
            }
            MODE_PHOTO_LIST_OLDEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithOldest(1, params.requestedLoadSize),
                        null,
                        4
                    )
                }
            }
            MODE_PHOTO_LIST_POPULAR -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithPopular(1, params.requestedLoadSize),
                        null,
                        4
                    )
                }
            }
            MODE_PHOTO_LIST_RANDOM -> {

            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        when (mode) {
            MODE_PHOTO_LIST_LATEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithLatest(
                            params.key,
                            params.requestedLoadSize
                        ), params.key - 1
                    )
                }
            }
            MODE_PHOTO_LIST_OLDEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithOldest(
                            params.key,
                            params.requestedLoadSize
                        ), params.key - 1
                    )
                }
            }
            MODE_PHOTO_LIST_POPULAR -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithPopular(
                            params.key,
                            params.requestedLoadSize
                        ), params.key - 1
                    )
                }
            }
            MODE_PHOTO_LIST_RANDOM -> {

            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        when (mode) {
            MODE_PHOTO_LIST_LATEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithLatest(
                            params.key,
                            params.requestedLoadSize
                        ), params.key + 1
                    )
                }
            }
            MODE_PHOTO_LIST_OLDEST -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithOldest(
                            params.key,
                            params.requestedLoadSize
                        ), params.key + 1
                    )
                }
            }
            MODE_PHOTO_LIST_POPULAR -> {
                launch {
                    callback.onResult(
                        model.getPhotosWithPopular(
                            params.key,
                            params.requestedLoadSize
                        ), params.key + 1
                    )
                }
            }
            MODE_PHOTO_LIST_RANDOM -> {

            }
        }
    }

    companion object {
        const val MODE_PHOTO_LIST_LATEST = "PHOTO_LIST_LATEST"
        const val MODE_PHOTO_LIST_POPULAR = "PHOTO_LIST_POPULAR"
        const val MODE_PHOTO_LIST_OLDEST = "PHOTO_LIST_OLDEST"
        const val MODE_PHOTO_LIST_RANDOM = "PHOTO_LIST_RANDOM"
    }
}