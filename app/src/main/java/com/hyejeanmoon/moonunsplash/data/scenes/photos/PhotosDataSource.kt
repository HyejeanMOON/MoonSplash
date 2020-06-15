package com.hyejeanmoon.moonunsplash.data.scenes.photos

import androidx.paging.PageKeyedDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * PhotosDataSource
 *
 * The effect of Paging's DataSource is help recycler to get more data smoothly and seamlessly.
 */
class PhotosDataSource(
    private val photoRemoteDataSource: PhotoRemoteDataSource,
    private val mode: String
) :
    PageKeyedDataSource<Int, Photo>(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        // Because of the numbers of photo are 3 times [per_page] when first time is loaded. So, we would set next page is 4, not 2.

        launch {
            callback.onResult(
                photoRemoteDataSource.getPhotos(
                    1,
                    params.requestedLoadSize,
                    when (mode) {
                        MODE_PHOTO_LIST_LATEST -> ORDER_LATEST
                        MODE_PHOTO_LIST_OLDEST -> ORDER_OLDEST
                        MODE_PHOTO_LIST_POPULAR -> ORDER_POPULAR
                        else -> ""
                    }

                ),
                null,
                4
            )
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        launch {
            callback.onResult(
                photoRemoteDataSource.getPhotos(
                    params.key,
                    params.requestedLoadSize,
                    when (mode) {
                        MODE_PHOTO_LIST_LATEST -> ORDER_LATEST
                        MODE_PHOTO_LIST_OLDEST -> ORDER_OLDEST
                        MODE_PHOTO_LIST_POPULAR -> ORDER_POPULAR
                        else -> ""
                    }
                ), params.key - 1
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        launch {
            callback.onResult(
                photoRemoteDataSource.getPhotos(
                    params.key,
                    params.requestedLoadSize,
                    when (mode) {
                        MODE_PHOTO_LIST_LATEST -> ORDER_LATEST
                        MODE_PHOTO_LIST_OLDEST -> ORDER_OLDEST
                        MODE_PHOTO_LIST_POPULAR -> ORDER_POPULAR
                        else -> ""
                    }
                ), params.key + 1
            )
        }
    }

    companion object {
        const val MODE_PHOTO_LIST_LATEST = "PHOTO_LIST_LATEST"
        const val MODE_PHOTO_LIST_POPULAR = "PHOTO_LIST_POPULAR"
        const val MODE_PHOTO_LIST_OLDEST = "PHOTO_LIST_OLDEST"
        const val MODE_PHOTO_LIST_RANDOM = "PHOTO_LIST_RANDOM"
        private const val ORDER_POPULAR = "popular"
        private const val ORDER_OLDEST = "oldest"
        private const val ORDER_LATEST = "latest"
    }
}