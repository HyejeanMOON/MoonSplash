package com.hyejeanmoon.moonunsplash.domain.scenes.collections

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.domain.scenes.collections.entity.Collections

interface CollectionsModel {

    fun getCollections(): LiveData<PagedList<Collections>>

    fun getCollectionsById(id: String): LiveData<PagedList<Collections>>

}