package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Downloads

class DownloadsItem : Downloads {
    @Expose
    @SerializedName("total")
    override val total: Int? = null

    @Expose
    @SerializedName("historical")
    override val historical: HistoricalItem? = null
}