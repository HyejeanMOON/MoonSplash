package com.hyejeanmoon.moonunsplash.domain.scenes.photos

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

/**
 * PhotosModel
 *
 * interface of photos model.
 */
interface PhotosModel {

    /**
     * get a photo form server by id.
     */
    suspend fun getPhoto(id: String): Photo

    /**
     * get a list of photos from server with popular order.
     */
    fun getPhotosWithPopular(): LiveData<PagedList<Photo>>

    /**
     * get a list of photos from server with latest order.
     */
    fun getPhotosWithLatest(): LiveData<PagedList<Photo>>

    /**
     * get a list oof photos from server with oldest order.
     */
    fun getPhotosWithOldest(): LiveData<PagedList<Photo>>

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