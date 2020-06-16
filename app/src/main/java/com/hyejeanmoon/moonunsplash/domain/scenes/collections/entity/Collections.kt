package com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity

import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.CoverPhoto
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Links
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.User

interface Collections {
    val id: String?
    val title: String?
    val description: String?
    val publishedAt: String?
    val updatedAt: String?
    val curated: String?
    val totalPhotos: String?
    val pri: String?
    val shareKey: String?
    val coverPhoto: CoverPhoto?
    val user: User?
    val links: Links?
}