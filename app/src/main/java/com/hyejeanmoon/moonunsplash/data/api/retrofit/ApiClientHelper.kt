package com.hyejeanmoon.moonunsplash.data.api.retrofit

import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.service.PhotosApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        fun createPhotosApiService(
            baseUrl: String,
            okHttpClient: OkHttpClient
        ): PhotosApiService {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PhotosApiService::class.java)
        }
    }
}