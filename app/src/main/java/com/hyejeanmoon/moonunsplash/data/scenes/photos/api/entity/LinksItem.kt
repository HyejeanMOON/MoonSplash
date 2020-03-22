package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Links

class LinksItem : Links {
    @Expose
    @SerializedName("self")
    override val self: String? = null

    @Expose
    @SerializedName("html")
    override val html: String? = null

    @Expose
    @SerializedName("download")
    override val download: String? = null

    @Expose
    @SerializedName("download_location")
    override val downloadLocation: String? = null

    @Expose
    @SerializedName("photos")
    override val photos: String? = null

    @Expose
    @SerializedName("likes")
    override val likes: String? = null

    @Expose
    @SerializedName("portfolio")
    override val portfolio: String? = null

}