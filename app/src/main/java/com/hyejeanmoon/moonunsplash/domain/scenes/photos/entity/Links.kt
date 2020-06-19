package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Links : Serializable {
    val self: String?
    val html: String?
    val download: String?
    val downloadLocation: String?
    val photos: String?
    val likes: String?
    val portfolio: String?
}