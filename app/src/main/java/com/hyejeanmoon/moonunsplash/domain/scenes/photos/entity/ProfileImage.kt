package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface ProfileImage : Serializable {
    val small: String?
    val medium: String?
    val large: String?
}