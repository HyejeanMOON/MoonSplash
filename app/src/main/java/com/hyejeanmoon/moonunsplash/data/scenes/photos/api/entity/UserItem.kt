package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.User

class UserItem : User {

    @Expose
    @SerializedName("id")
    override val id: String? = null

    @Expose
    @SerializedName("updated_at")
    override val updatedAt: String? = null

    @Expose
    @SerializedName("username")
    override val userName: String? = null

    @Expose
    @SerializedName("name")
    override val name: String? = null

    @Expose
    @SerializedName("portfolio_url")
    override val portfolioUrl: String? = null

    @Expose
    @SerializedName("bio")
    override val bio: String? = null

    @Expose
    @SerializedName("location")
    override val location: String? = null

    @Expose
    @SerializedName("total_likes")
    override val totalLikes: Int? = null

    @Expose
    @SerializedName("total_photos")
    override val totalPhotos: Int? = null

    @Expose
    @SerializedName("total_collections")
    override val totalCollections: Int? = null

    @Expose
    @SerializedName("links")
    override val links: LinksItem? = null

    @Expose
    @SerializedName("profile_image")
    override val profileImage: ProfileImageItem? = null

    @Expose
    @SerializedName("instagram_username")
    override val instagramUserName: String? = null

    @Expose
    @SerializedName("twitter_username")
    override val twitterUserName: String? = null
}