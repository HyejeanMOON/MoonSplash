package com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity

interface Exif {
    val make: String?
    val model: String?
    val exposureTime: String?
    val aperture: String?
    val focalLength: String?
    val iso: Int?
}