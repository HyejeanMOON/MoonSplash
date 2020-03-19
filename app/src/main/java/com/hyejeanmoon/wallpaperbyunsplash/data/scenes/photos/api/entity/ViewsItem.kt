package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Views

class ViewsItem : Views {

    @SerializedName("total")
    override val total: Int? = null

    @SerializedName("historical")
    override val historical: HistoricalItem? = null
}