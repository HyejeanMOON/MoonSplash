package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Location : Serializable {
    val city: String?
    val country: String?
    val position: Position?
}