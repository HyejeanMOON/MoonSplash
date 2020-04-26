package com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource

import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Collections

interface CollectionsRemoteDataSource {

    suspend fun getCollections(page: Int, perPage: Int): List<Collections>
}