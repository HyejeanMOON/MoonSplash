package com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Values

class ValuesItem : Values {
    @Expose
    @SerializedName("date")
    override val date: String? = null

    @Expose
    @SerializedName("value")
    override val value: Int? = null
}