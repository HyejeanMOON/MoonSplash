package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Urls

class UrlsItem : Urls {

    @Expose
    @SerializedName("url")
    override val url: String? = null

    @Expose
    @SerializedName("raw")
    override val raw: String? = null

    @Expose
    @SerializedName("full")
    override val full: String? = null

    @Expose
    @SerializedName("regular")
    override val regular: String? = null

    @Expose
    @SerializedName("small")
    override val small: String? = null

    @Expose
    @SerializedName("thumb")
    override val thumb: String? = null

}