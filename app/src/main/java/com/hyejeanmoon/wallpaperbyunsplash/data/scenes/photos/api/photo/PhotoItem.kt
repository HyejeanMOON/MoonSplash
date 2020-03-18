package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Exif
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Photo

class PhotoItem : Photo {
    @SerializedName("id")
    override val id: String? = null

    @SerializedName("created_at")
    override val createdAt: String? = null

    @SerializedName("updated_at")
    override val updatedAt: String? = null

    @SerializedName("width")
    override val width: Int? = null

    @SerializedName("height")
    override val height: Int? = null

    @SerializedName("color")
    override val color: String? = null

    @SerializedName("downloads")
    override val downloads: Int? = null

    @SerializedName("likes")
    override val likes: Int? = null

    @SerializedName("liked_by_user")
    override val likedByUser: Boolean? = null

    @SerializedName("description")
    override val description: String? = null

    @SerializedName("exif")
    override val exif: Exif? = null

    @SerializedName("links")
    override val links: LinksItem? = null

    @SerializedName("location")
    override val location: LocationItem? = null

    @SerializedName("tags")
    override val tags: List<TagsItem>? = null

    @SerializedName("urls")
    override val urls: UrlsItem? = null

    @SerializedName("user")
    override val user: UserItem? = null

    @SerializedName("current_user_collections")
    override val currentUserCollections: List<CurrentUserCollectionsItem>? = null


}