package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

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