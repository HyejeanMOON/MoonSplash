package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * PhotosViewModel
 *
 * It's a ViewModel of PopularPhotosFragment and LatestPhotosFragment.
 */
class PhotosViewModel(
    private val photosModel: PhotosModel
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    fun getPhotoWithPopular(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(
            PhotosDataSourceFactory(
                photosModel, PhotosDataSource.MODE_PHOTO_LIST_POPULAR
            ),
            PagedList.Config.Builder().setPageSize(5).setMaxSize(15).setEnablePlaceholders(true)
                .build()
        ).build()
    }

    fun getPhotoWithLatest(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(
            PhotosDataSourceFactory(
                photosModel, PhotosDataSource.MODE_PHOTO_LIST_LATEST
            ),
            PagedList.Config.Builder().setPageSize(5).setMaxSize(15).setEnablePlaceholders(true)
                .build()
        ).build()
    }

    class Factory @Inject constructor(
        private val photosModel: PhotosModel
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == PhotosViewModel::class.java) {
                return PhotosViewModel(
                    photosModel
                ) as T
            }
            val className = modelClass.name
            throw IllegalArgumentException("Unknown ViewModel class : $className")
        }
    }

}