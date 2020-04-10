package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _popularPhotos = MutableLiveData<PagedList<Photo>>()
    val popularPhotos: LiveData<PagedList<Photo>> get() = _popularPhotos

    private val _latestPhotos = MutableLiveData<PagedList<Photo>>()
    val latestPhotos: LiveData<PagedList<Photo>> get() = _latestPhotos

    fun getPhotoWithPopular(): LiveData<PagedList<Photo>> {
        return photosModel.getPhotosWithPopular()
    }

    fun getPhotoWithLatest(): LiveData<PagedList<Photo>> {
        return photosModel.getPhotosWithLatest()
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