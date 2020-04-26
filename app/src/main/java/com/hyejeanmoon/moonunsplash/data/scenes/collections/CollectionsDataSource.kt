package com.hyejeanmoon.moonunsplash.data.scenes.collections

import androidx.paging.PageKeyedDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.datasource.CollectionsRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Collections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CollectionsDataSource(
    private val collectionsRemoteDataSource: CollectionsRemoteDataSource
) : PageKeyedDataSource<Int, Collections>(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Collections>
    ) {
        launch {
            callback.onResult(
                collectionsRemoteDataSource.getCollections(
                    1,
                    params.requestedLoadSize
                ), null, 4
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Collections>) {
        launch {
            callback.onResult(
                collectionsRemoteDataSource.getCollections(
                    params.key,
                    params.requestedLoadSize
                ), params.key - 1
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Collections>) {
        launch {
            callback.onResult(
                collectionsRemoteDataSource.getCollections(
                    params.key,
                    params.requestedLoadSize
                ), params.key + 1
            )
        }
    }
}