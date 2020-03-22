package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

interface Historical {
    val change: Int?
    val average: Int?
    val resolution: String?
    val quantity: Int?
    val values: List<Values>?
}