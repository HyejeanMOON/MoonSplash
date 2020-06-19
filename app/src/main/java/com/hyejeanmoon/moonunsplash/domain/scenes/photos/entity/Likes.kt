package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Likes : Serializable {
    val total: Int?
    val historical: Historical?
}