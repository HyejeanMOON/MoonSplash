package com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos

import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo

interface PhotosModel {

    suspend fun getPhoto(id: String): Photo

    suspend fun getPhotosWithPopular(page: Int, perPage: Int): List<Photo>

    suspend fun getPhotosWithLatest(page: Int, perPage: Int): List<Photo>

    suspend fun getPhotosWithOldest(page: Int, perPage: Int): List<Photo>

    suspend fun getPhotoWithRandom(): Photo

    suspend fun getPhotosWithRandom(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<Photo>

}