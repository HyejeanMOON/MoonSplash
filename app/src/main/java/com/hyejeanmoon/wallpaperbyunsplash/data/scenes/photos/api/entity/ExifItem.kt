package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Exif

class ExifItem : Exif {

    @Expose
    @SerializedName("make")
    override val make: String? = null

    @Expose
    @SerializedName("model")
    override val model: String? = null

    @Expose
    @SerializedName("exposure_time")
    override val exposureTime: String? = null

    @Expose
    @SerializedName("aperture")
    override val aperture: String? = null

    @Expose
    @SerializedName("focal_length")
    override val focalLength: String? = null

    @Expose
    @SerializedName("iso")
    override val iso: Int? = null

}