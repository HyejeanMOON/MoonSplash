package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.User

class UserItem : User {

    @SerializedName("id")
    override val id: String? = null

    @SerializedName("updated_at")
    override val updatedAt: String? = null

    @SerializedName("username")
    override val userName: String? = null

    @SerializedName("name")
    override val name: String? = null

    @SerializedName("portfolio_url")
    override val portfolioUrl: String? = null

    @SerializedName("bio")
    override val bio: String? = null

    @SerializedName("location")
    override val location: String? = null

    @SerializedName("total_likes")
    override val totalLikes: Int? = null

    @SerializedName("total_photos")
    override val totalPhotos: Int? = null

    @SerializedName("total_collections")
    override val totalCollections: Int? = null

    @SerializedName("links")
    override val links: LinksItem? = null

    @SerializedName("profile_image")
    override val profileImage: ProfileImageItem? = null

    @SerializedName("instagram_username")
    override val instagramUserName: String? = null

    @SerializedName("twitter_username")
    override val twitterUserName: String? = null
}