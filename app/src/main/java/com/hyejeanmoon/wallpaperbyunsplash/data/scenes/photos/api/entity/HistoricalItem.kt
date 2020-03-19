package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Historical

class HistoricalItem : Historical {

    @SerializedName("change")
    override val change: Int? = null

    @SerializedName("average")
    override val average: Int? = null

    @SerializedName("resolution")
    override val resolution: String? = null

    @SerializedName("quantity")
    override val quantity: Int? = null

    @SerializedName("values")
    override val values: List<ValuesItem>? = null
}