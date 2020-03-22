package com.hyejeanmoon.moonunsplash.domain.scenes.photos

import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

/**
 * PhotosModel
 *
 * It's interface of photos model.
 */
interface PhotosModel {

    /**
     * get a photo form server by id.
     */
    suspend fun getPhoto(id: String): Photo

    /**
     * get a list of photos from server with popular order.
     */
    suspend fun getPhotosWithPopular(page: Int, perPage: Int): List<Photo>

    /**
     * get a list of photos from server with latest order.
     */
    suspend fun getPhotosWithLatest(page: Int, perPage: Int): List<Photo>

    /**
     * get a list oof photos from server with oldest order.
     */
    suspend fun getPhotosWithOldest(page: Int, perPage: Int): List<Photo>

    /**
     * get a photo with random without any parameters.
     */
    suspend fun getPhotoWithRandom(): Photo

    /**
     * get a list of photos  with random by parameters.
     */
    suspend fun getPhotosWithRandom(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<Photo>

}