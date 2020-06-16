package com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource

import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections

interface CollectionsRemoteDataSource {

    suspend fun getCollections(page: Int, perPage: Int): List<Collections>

    suspend fun getCollectionsById(id: String, page: Int, perPage: Int): List<Collections>
}