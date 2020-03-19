package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.CoverPhoto

class CoverPhotoItem : CoverPhoto {

    @SerializedName("id")
    override val id: String? = null

    @SerializedName("width")
    override val width: Int? = null

    @SerializedName("height")
    override val height: Int? = null

    @SerializedName("color")
    override val color: String? = null

    @SerializedName("likes")
    override val likes: Int? = null

    @SerializedName("liked_by_user")
    override val likedByUser: Boolean? = null

    @SerializedName("description")
    override val description: String? = null

    @SerializedName("user")
    override val user: UserItem? = null

    @SerializedName("urls")
    override val urls: UrlsItem? = null

}