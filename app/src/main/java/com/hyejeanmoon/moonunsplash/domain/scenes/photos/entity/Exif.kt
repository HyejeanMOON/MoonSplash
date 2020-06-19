package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Exif : Serializable {
    val make: String?
    val model: String?
    val exposureTime: String?
    val aperture: String?
    val focalLength: String?
    val iso: Int?
}