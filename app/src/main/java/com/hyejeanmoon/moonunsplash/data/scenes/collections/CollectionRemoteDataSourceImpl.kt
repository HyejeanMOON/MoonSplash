package com.hyejeanmoon.moonunsplash.data.scenes.collections

import com.hyejeanmoon.moonunsplash.data.api.retrofit.ApiEnqueueCallback
import com.hyejeanmoon.moonunsplash.data.scenes.collections.service.CollectionsApiService
import com.hyejeanmoon.moonunsplash.data.scenes.photos.api.entity.CollectionsItem
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class CollectionRemoteDataSourceImpl(
    private val collectionsApiService: CollectionsApiService
) : CollectionsRemoteDataSource {

    override suspend fun getCollections(page: Int, perPage: Int): List<CollectionsItem> =
        suspendCoroutine {
            collectionsApiService.getCollections(page, perPage).enqueue(
                ApiEnqueueCallback({ response ->
                    it.resume(response)
                }, { exception ->
                    it.resumeWithException(exception)
                })
            )
        }

}