package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

import java.io.Serializable

interface CurrentUserCollections : Serializable {
    val id: Int?
    val title: String?
    val publishedAt: String?
    val curated: Boolean?
    val coverPhoto: String?
    val user: String?
}