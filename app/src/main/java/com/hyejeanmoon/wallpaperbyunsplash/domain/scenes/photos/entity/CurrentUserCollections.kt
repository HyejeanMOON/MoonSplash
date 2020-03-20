package com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity

interface CurrentUserCollections {
    val id: Int?
    val title: String?
    val publishedAt: String?
    val curated: Boolean?
    val coverPhoto: String?
    val user: String?
}