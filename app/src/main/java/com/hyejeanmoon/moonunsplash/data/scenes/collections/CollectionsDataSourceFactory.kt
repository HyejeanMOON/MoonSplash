package com.hyejeanmoon.moonunsplash.data.scenes.collections

import androidx.paging.DataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections
import javax.inject.Singleton

@Singleton
class CollectionsDataSourceFactory(
    private val collectionsRemoteDataSource: CollectionsRemoteDataSource
) : DataSource.Factory<Int, Collections>() {

    override fun create(): DataSource<Int, Collections> {
        return CollectionsDataSource(collectionsRemoteDataSource)
    }
}