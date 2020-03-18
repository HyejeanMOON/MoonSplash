package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Location

class LocationItem : Location {

    @SerializedName("city")
    override val city: String? = null

    @SerializedName("country")
    override val country: String? = null

    @SerializedName("position")
    override val position: PositionItem? = null
    
}