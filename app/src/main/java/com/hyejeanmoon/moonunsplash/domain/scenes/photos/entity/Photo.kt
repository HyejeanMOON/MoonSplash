package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

interface Photo {
    val id: String?
    val createdAt: String?
    val updatedAt: String?
    val width: Int?
    val height: Int?
    val color: String?
    val downloads: Int?
    val likes: Int?
    val likedByUser: Boolean?
    val description: String?
    val exif: Exif?
    val links: Links?
    val location: Location?
    val tags: List<Tags>?
    val urls: Urls?
    val user: User?
    val currentUserCollections: List<CurrentUserCollections>?
}