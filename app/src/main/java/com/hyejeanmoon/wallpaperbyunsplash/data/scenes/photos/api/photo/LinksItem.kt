package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Links

class LinksItem : Links {
    @SerializedName("self")
    override val self: String? = null

    @SerializedName("html")
    override val html: String? = null

    @SerializedName("download")
    override val download: String? = null

    @SerializedName("download_location")
    override val downloadLocation: String? = null

    @SerializedName("photos")
    override val photos: String? = null

    @SerializedName("likes")
    override val likes: String? = null

    @SerializedName("portfolio")
    override val portfolio: String? = null

}