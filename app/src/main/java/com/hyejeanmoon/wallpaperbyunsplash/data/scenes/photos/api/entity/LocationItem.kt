package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Location

class LocationItem : Location {

    @Expose
    @SerializedName("city")
    override val city: String? = null

    @Expose
    @SerializedName("country")
    override val country: String? = null

    @Expose
    @SerializedName("position")
    override val position: PositionItem? = null

}