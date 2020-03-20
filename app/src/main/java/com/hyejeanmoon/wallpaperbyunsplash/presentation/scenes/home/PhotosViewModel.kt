package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PhotosViewModel(
    private val photosModel: PhotosModel
) : ViewModel(), CoroutineScope {

    private val _photo = MutableLiveData<Photo>()
    val photo: LiveData<Photo> get() = _photo

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    fun getPhotoWithRandom() {
        launch {
            _photo.value = photosModel.getPhotoWithRandom()
        }
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