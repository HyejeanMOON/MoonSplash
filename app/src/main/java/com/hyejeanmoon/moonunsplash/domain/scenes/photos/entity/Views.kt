package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface Views : Serializable {
    val total: Int?
    val historical: Historical?
}