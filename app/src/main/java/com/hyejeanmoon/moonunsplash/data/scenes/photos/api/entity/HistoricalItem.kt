package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Historical

class HistoricalItem : Historical {

    @Expose
    @SerializedName("change")
    override val change: Int? = null

    @Expose
    @SerializedName("average")
    override val average: Int? = null

    @Expose
    @SerializedName("resolution")
    override val resolution: String? = null

    @Expose
    @SerializedName("quantity")
    override val quantity: Int? = null

    @Expose
    @SerializedName("values")
    override val values: List<ValuesItem>? = null
}