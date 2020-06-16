package com.hyejeanmoon.moonunsplash.domain.scenes.collections.model

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.data.scenes.collections.CollectionsDataSourceFactory
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.CollectionsModel
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections

class CollectionsModelImpl(
    private val collectionRemoteDataSource: CollectionsRemoteDataSource,
    private val collectionsDataSourceFactory: CollectionsDataSourceFactory
) : CollectionsModel {

    override fun getCollections(): LiveData<PagedList<Collections>> {
        return LivePagedListBuilder(
            collectionsDataSourceFactory,
            PagedList.Config.Builder().setPageSize(10).setMaxSize(30).setEnablePlaceholders(true)
                .setPrefetchDistance(3).setInitialLoadSizeHint(10)
                .build()
        ).build()
    }

    override fun getCollectionsById(id: String): LiveData<PagedList<Collections>> {
        TODO("Not yet implemented")
    }
}