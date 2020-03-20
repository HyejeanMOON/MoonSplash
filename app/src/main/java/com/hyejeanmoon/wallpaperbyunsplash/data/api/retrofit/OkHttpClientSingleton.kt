package com.hyejeanmoon.wallpaperbyunsplash.data.api.retrofit

import com.hyejeanmoon.wallpaperbyunsplash.utils.EnvParameters
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
class OkHttpClientSingleton {
    private var okHttpClient: OkHttpClient

    init {

        val okHttpBuilder = OkHttpClient.Builder()
        // setting timeout for okHttpClient
        okHttpBuilder.connectTimeout(CONNECT_TIMEOUT_SECOND.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(READ_TIMEOUT_SECOND.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(WRITE_TIMEOUT_SECOND.toLong(), TimeUnit.SECONDS)

        okHttpClient = okHttpBuilder.build()
    }

    val plainOkHttpClient: OkHttpClient
        get() = okHttpClient.newBuilder()
            .addInterceptor(ApiInterceptor(EnvParameters.CLIENT_ID)).build()

    companion object {
        private const val CONNECT_TIMEOUT_SECOND = 20
        private const val READ_TIMEOUT_SECOND = 32
        private const val WRITE_TIMEOUT_SECOND = 32
    }
}