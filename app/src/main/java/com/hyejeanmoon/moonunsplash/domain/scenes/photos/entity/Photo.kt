package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Photo : Serializable {
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