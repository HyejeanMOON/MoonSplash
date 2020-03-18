package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.photo

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Likes

class LikesItem : Likes {

    @SerializedName("total")
    override val total: Int? = null

    @SerializedName("historical")
    override val historical: HistoricalItem? = null
}