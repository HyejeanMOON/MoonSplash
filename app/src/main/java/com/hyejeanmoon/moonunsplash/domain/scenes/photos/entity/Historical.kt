package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Historical : Serializable {
    val change: Int?
    val average: Int?
    val resolution: String?
    val quantity: Int?
    val values: List<Values>?
}