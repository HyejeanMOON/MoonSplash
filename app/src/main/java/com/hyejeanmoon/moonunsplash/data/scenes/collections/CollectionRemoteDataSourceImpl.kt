package com.hyejeanmoon.moonunsplash.data.scenes.collections

import com.hyejeanmoon.moonunsplash.data.api.retrofit.ApiEnqueueCallback
import com.hyejeanmoon.moonunsplash.data.scenes.collections.api.entity.CollectionsItem
import com.hyejeanmoon.moonunsplash.data.scenes.collections.api.service.CollectionsApiService
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections
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

    override suspend fun getCollectionsById(
        id: String,
        page: Int,
        perPage: Int
    ): List<Collections> = suspendCoroutine {
        collectionsApiService.getCollections(id, page, perPage).enqueue(
            ApiEnqueueCallback({ response ->
                it.resume(response)
            }, { exception ->
                it.resumeWithException(exception)
            })
        )
    }
}