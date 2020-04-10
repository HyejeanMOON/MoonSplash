package com.hyejeanmoon.moonunsplash.data.scenes.photos

import androidx.paging.DataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo
import javax.inject.Singleton

/**
 * PopularPhotosDataSourceFactory
 *
 * It's a Factory for PhotoDataSource that help DataSource to create.
 */
@Singleton
class OldestPhotosDataSourceFactory(
    private val photoRemoteDataSource: PhotoRemoteDataSource,
    private val mode: String
) :
    DataSource.Factory<Int, Photo>() {

    override fun create(): DataSource<Int, Photo> {
        return PhotosDataSource(
            photoRemoteDataSource,
            mode
        )
    }
}