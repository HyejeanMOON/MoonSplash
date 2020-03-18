package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Collections
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Links
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.User

class CollectionsItem : Collections {

    @SerializedName("id")
    override val id: String? = null

    @SerializedName("title")
    override val title: String? = null

    @SerializedName("description")
    override val description: String? = null

    @SerializedName("published_at")
    override val publishedAt: String? = null

    @SerializedName("updated_at")
    override val updatedAt: String? = null

    @SerializedName("curated")
    override val curated: String? = null

    @SerializedName("total_photos")
    override val totalPhotos: String? = null

    @SerializedName("private")
    override val pri: String? = null

    @SerializedName("share_key")
    override val shareKey: String? = null

    @SerializedName("cover_photo")
    override val coverPhoto: CoverPhotoItem? = null

    @SerializedName("user")
    override val user: User? = null

    @SerializedName("links")
    override val links: Links? = null
}