package com.hyejeanmoon.moonunsplash.presentation.scenes.home.photos

import androidx.paging.DataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

class PhotosDataSourceFactory(private val model: PhotosModel, private val mode: String) :
    DataSource.Factory<Int, Photo>() {

    override fun create(): DataSource<Int, Photo> {
        return PhotosDataSource(
            model,
            mode
        )
    }
}