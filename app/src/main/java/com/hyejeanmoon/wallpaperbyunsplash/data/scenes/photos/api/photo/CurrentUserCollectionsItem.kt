package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.CurrentUserCollections

class CurrentUserCollectionsItem : CurrentUserCollections {
    @SerializedName("id")
    override val id: Int? = null

    @SerializedName("title")
    override val title: String? = null

    @SerializedName("published_at")
    override val publishedAt: String? = null

    @SerializedName("curated")
    override val curated: Boolean? = null

    @SerializedName("cover_photo")
    override val coverPhoto: String? = null

    @SerializedName("user")
    override val user: UserItem? = null


}