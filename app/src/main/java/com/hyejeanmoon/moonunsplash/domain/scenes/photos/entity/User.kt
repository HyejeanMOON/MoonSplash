package com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity

interface User {
    val id: String?
    val updatedAt: String?
    val userName: String?
    val name: String?
    val portfolioUrl: String?
    val bio: String?
    val location: String?
    val totalLikes: Int?
    val totalPhotos: Int?
    val totalCollections: Int?
    val links: Links?
    val profileImage: ProfileImage?
    val instagramUserName: String?
    val twitterUserName: String?

}