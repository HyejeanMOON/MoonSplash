package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Position : Serializable {
    val latitude: Double?
    val longitude: Double?
}