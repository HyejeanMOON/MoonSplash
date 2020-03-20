package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.CurrentUserCollections

class CurrentUserCollectionsItem : CurrentUserCollections {
    @Expose
    @SerializedName("id")
    override val id: Int? = null

    @Expose
    @SerializedName("title")
    override val title: String? = null

    @Expose
    @SerializedName("published_at")
    override val publishedAt: String? = null

    @Expose
    @SerializedName("curated")
    override val curated: Boolean? = null

    @Expose
    @SerializedName("cover_photo")
    override val coverPhoto: String? = null

    @Expose
    @SerializedName("user")
    override val user: String? = null

}