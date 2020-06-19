package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Urls : Serializable {
    val url: String?
    val raw: String?
    val full: String?
    val regular: String?
    val small: String?
    val thumb: String?
}