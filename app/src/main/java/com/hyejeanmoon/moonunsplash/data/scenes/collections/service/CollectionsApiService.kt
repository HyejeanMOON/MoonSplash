package com.hyejeanmoon.moonunsplash.data.scenes.collections.service

import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.CollectionsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsApiService {
    /**
     * get a list of photo collections curated.
     *
     * param:
     * page: optional, default 1;
     * per_page: optional, default 10;
     */
    @GET("/collections/curated")
    fun getCollections(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<CollectionsItem>>

    /**
     * get a photo collection.
     *
     * param:
     * id: The collection’s ID. Required.
     * page: optional, default 1;
     * per_page: optional, default 10;
     */
    @GET("/collection/@{id}/photos")
    fun getCollections(
        @Path("id") id: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<CollectionsItem>>
}