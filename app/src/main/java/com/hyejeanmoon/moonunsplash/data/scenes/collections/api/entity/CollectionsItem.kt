package com.hyejeanmoon.moonunsplash.data.scenes.collections.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.CoverPhotoItem
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.LinksItem
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.UserItem
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections

class CollectionsItem :
    Collections {

    @Expose
    @SerializedName("id")
    override val id: String? = null

    @Expose
    @SerializedName("title")
    override val title: String? = null

    @Expose
    @SerializedName("description")
    override val description: String? = null

    @Expose
    @SerializedName("published_at")
    override val publishedAt: String? = null

    @Expose
    @SerializedName("updated_at")
    override val updatedAt: String? = null

    @Expose
    @SerializedName("curated")
    override val curated: String? = null

    @Expose
    @SerializedName("total_photos")
    override val totalPhotos: String? = null

    @Expose
    @SerializedName("private")
    override val pri: String? = null

    @Expose
    @SerializedName("share_key")
    override val shareKey: String? = null

    @Expose
    @SerializedName("cover_photo")
    override val coverPhoto: CoverPhotoItem? = null

    @Expose
    @SerializedName("user")
    override val user: UserItem? = null

    @Expose
    @SerializedName("links")
    override val links: LinksItem? = null
}