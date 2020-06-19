package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Statistics : Serializable {
    val userName: String?
    val downloads: Downloads?
    val views: Views?
    val likes: Likes?
}