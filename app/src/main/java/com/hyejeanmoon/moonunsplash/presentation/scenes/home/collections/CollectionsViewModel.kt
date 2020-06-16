package com.hyejeanmoon.moonunsplash.presentation.scenes.home.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.CollectionsModel
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CollectionsViewModel(
    private val collectionsModel: CollectionsModel
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    fun getCollections(): LiveData<PagedList<Collections>> {
        return collectionsModel.getCollections()
    }

    class Factory @Inject constructor(
        private val collectionsModel: CollectionsModel
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == CollectionsViewModel::class.java) {
                return CollectionsViewModel(
                    collectionsModel
                ) as T
            }
            val className = modelClass.name
            throw IllegalArgumentException("Unknown ViewModel class : $className")
        }
    }
}