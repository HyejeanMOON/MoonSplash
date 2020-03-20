package com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.datasource

import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo

/**
 * PhotoRemoteDataSource
 *
 * It's interface of photos' remote data source.
 */
interface PhotoRemoteDataSource {

    /**
     * get a photo from server by id.
     */
    suspend fun getPhoto(id: String): Photo

    /**
     * get a list of photos from server by parameters.
     */
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<Photo>

    /**
     * get a list of photos from server with random by parameters.
     */
    suspend fun getRandomPhotos(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<Photo>

    /**
     * get a photo from server with random without any parameters.
     */
    suspend fun getRandomPhoto(): Photo
}