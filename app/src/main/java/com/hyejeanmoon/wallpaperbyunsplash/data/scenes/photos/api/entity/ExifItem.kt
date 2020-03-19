package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Exif

class ExifItem : Exif {

    @SerializedName("make")
    override val make: String? = null

    @SerializedName("model")
    override val model: String? = null

    @SerializedName("exposure_time")
    override val exposureTime: String? = null

    @SerializedName("aperture")
    override val aperture: String? = null

    @SerializedName("focal_length")
    override val focalLength: String? = null

    @SerializedName("iso")
    override val iso: Int? = null

}