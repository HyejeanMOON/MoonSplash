package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Position

class PositionItem : Position {

    @Expose
    @SerializedName("latitude")
    override val latitude: Double? = null

    @Expose
    @SerializedName("longitude")
    override val longitude: Double? = null
}