package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface CoverPhoto : Serializable {
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