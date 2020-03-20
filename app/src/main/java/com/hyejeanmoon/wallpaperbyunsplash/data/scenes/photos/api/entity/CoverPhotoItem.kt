package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.CoverPhoto

class CoverPhotoItem : CoverPhoto {

    @Expose
    @SerializedName("id")
    override val id: String? = null

    @Expose
    @SerializedName("width")
    override val width: Int? = null

    @Expose
    @SerializedName("height")
    override val height: Int? = null

    @Expose
    @SerializedName("color")
    override val color: String? = null

    @Expose
    @SerializedName("likes")
    override val likes: Int? = null

    @Expose
    @SerializedName("liked_by_user")
    override val likedByUser: Boolean? = null

    @Expose
    @SerializedName("description")
    override val description: String? = null

    @Expose
    @SerializedName("user")
    override val user: UserItem? = null

    @Expose
    @SerializedName("urls")
    override val urls: UrlsItem? = null

}