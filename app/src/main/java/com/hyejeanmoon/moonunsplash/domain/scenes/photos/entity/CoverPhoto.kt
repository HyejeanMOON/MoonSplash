package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

interface CoverPhoto {
    val id: String?
    val width: Int?
    val height: Int?
    val color: String?
    val likes: Int?
    val likedByUser: Boolean?
    val description: String?
    val user: User?
    val urls: Urls?
}