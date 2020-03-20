package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.ProfileImage

class ProfileImageItem : ProfileImage {

    @Expose
    @SerializedName("small")
    override val small: String? = null

    @Expose
    @SerializedName("medium")
    override val medium: String? = null

    @Expose
    @SerializedName("large")
    override val large: String? = null
}