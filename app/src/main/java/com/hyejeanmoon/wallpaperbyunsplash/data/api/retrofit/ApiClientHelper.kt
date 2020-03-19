package com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit

import javax.inject.Singleton

/**
 * ApiClientHelper
 *
 * It's help to create a ApiService of Retrofit by Dagger
 */
@Singleton
class ApiClientHelper constructor(
    val baseUrl: String
) {
    companion object {

    }
}