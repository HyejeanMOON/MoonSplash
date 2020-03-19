package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.ProfileImage

class ProfileImageItem : ProfileImage {

    @SerializedName("small")
    override val small: String? = null

    @SerializedName("medium")
    override val medium: String? = null

    @SerializedName("large")
    override val large: String? = null
}