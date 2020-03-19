package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Urls

class UrlsItem : Urls {

    @SerializedName("url")
    override val url: String? = null

    @SerializedName("raw")
    override val raw: String? = null

    @SerializedName("full")
    override val full: String? = null

    @SerializedName("regular")
    override val regular: String? = null

    @SerializedName("small")
    override val small: String? = null

    @SerializedName("thumb")
    override val thumb: String? = null

}