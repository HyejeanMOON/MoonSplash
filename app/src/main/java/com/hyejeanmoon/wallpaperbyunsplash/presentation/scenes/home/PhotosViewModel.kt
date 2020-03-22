package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PhotosViewModel(
    private val photosModel: PhotosModel
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    fun getPhotoWithPopular(): LiveData<PagedList<Photo>> {
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