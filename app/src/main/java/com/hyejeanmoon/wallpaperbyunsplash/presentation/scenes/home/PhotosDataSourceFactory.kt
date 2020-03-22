package com.hyejeanmoon.wallpaperbyunsplash.presentation.scenes.home

import androidx.paging.DataSource
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo

class PhotosDataSourceFactory(private val model: PhotosModel, private val mode: String) :
    DataSource.Factory<Int, Photo>() {

    override fun create(): DataSource<Int, Photo> {
        return PhotosDataSource(model, mode)
    }
}