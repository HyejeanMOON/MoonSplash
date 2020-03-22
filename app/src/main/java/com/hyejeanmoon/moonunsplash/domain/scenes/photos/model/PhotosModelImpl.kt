package com.hyejeanmoon.moonunsplash.domain.scenes.photos.model

import com.hyejeanmoon.moonunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

/**
 * PhotosModelImpl
 *
 * It's implementation of photos model.
 */
class PhotosModelImpl(
    private val photoRemoteDataSource: PhotoRemoteDataSource
) : PhotosModel {

    override suspend fun getPhoto(id: String): Photo {
        return photoRemoteDataSource.getPhoto(id)
    }

    override suspend fun getPhotosWithPopular(page: Int, perPage: Int): List<Photo> {
        return photoRemoteDataSource.getPhotos(page, perPage, ORDER_POPULAR)
    }

    override suspend fun getPhotosWithLatest(page: Int, perPage: Int): List<Photo> {
        return photoRemoteDataSource.getPhotos(page, perPage, ORDER_LATEST)
    }

    override suspend fun getPhotosWithOldest(page: Int, perPage: Int): List<Photo> {
        return photoRemoteDataSource.getPhotos(page, perPage, ORDER_OLDEST)
    }

    override suspend fun getPhotoWithRandom(): Photo {
        return photoRemoteDataSource.getRandomPhoto()
    }

    override suspend fun getPhotosWithRandom(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<Photo> {
        return photoRemoteDataSource.getRandomPhotos(
            collections,
            featured,
            userName,
            query,
            orientation,
            count
        )
    }

    companion object {
        private const val ORDER_POPULAR = "popular"
        private const val ORDER_OLDEST = "oldest"
        private const val ORDER_LATEST = "latest"
    }
}