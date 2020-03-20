package com.hyejeanmoon.wallpaperbyunsplash.data.scenes.photos.api.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyejeanmoon.wallpaperbyunsplash.domain.scenes.photos.entity.Statistics

class StatisticsItem : Statistics {

    @Expose
    @SerializedName("username")
    override val userName: String? = null

    @Expose
    @SerializedName("downloads")
    override val downloads: DownloadsItem? = null

    @Expose
    @SerializedName("views")
    override val views: ViewsItem? = null

    @Expose
    @SerializedName("likes")
    override val likes: LikesItem? = null
}