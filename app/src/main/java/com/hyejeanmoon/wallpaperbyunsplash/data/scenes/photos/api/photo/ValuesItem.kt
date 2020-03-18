package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Values

class ValuesItem : Values {
    @SerializedName("date")
    override val date: String? = null

    @SerializedName("value")
    override val value: String? = null
}