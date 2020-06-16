package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
        return photosModel.getPhotosWithPopular()
    }

    fun getPhotoWithLatest(): LiveData<PagedList<Photo>> {
        return photosModel.getPhotosWithLatest()
    }

    fun getPhotoWithOldest(): LiveData<PagedList<Photo>> {
        return photosModel.getPhotosWithOldest()
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