package com.hyejeanmoon.moonunsplash.domain.scenes.photos.model

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hyejeanmoon.moonunsplash.data.scenes.photos.LatestPhotosDataSourceFactory
import com.hyejeanmoon.moonunsplash.data.scenes.photos.OldestPhotosDataSourceFactory
import com.hyejeanmoon.moonunsplash.data.scenes.photos.PopularPhotosDataSourceFactory
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.PhotosModel
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.datasource.PhotoRemoteDataSource
import com.hyejeanmoon.moonunsplash.domain.scenes.photos.entity.Photo

/**
 * PhotosModelImpl
 *
 * It's implementation of photos model.
 */
class PhotosModelImpl(
    private val photoRemoteDataSource: PhotoRemoteDataSource,
    private val latestPhotosDataSourceFactory: LatestPhotosDataSourceFactory,
    private val popularPhotosDataSourceFactory: PopularPhotosDataSourceFactory,
    private val oldestPhotosDataSourceFactory: OldestPhotosDataSourceFactory
) : PhotosModel {

    override suspend fun getPhoto(id: String): Photo {
        return photoRemoteDataSource.getPhoto(id)
    }

    override fun getPhotosWithPopular(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(
            popularPhotosDataSourceFactory,
            PagedList.Config.Builder().setPageSize(5).setMaxSize(15).setEnablePlaceholders(true)
                .build()
        ).build()
    }

    override fun getPhotosWithLatest(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(
            latestPhotosDataSourceFactory,
            PagedList.Config.Builder().setPageSize(5).setMaxSize(15).setEnablePlaceholders(true)
                .build()
        ).build()
    }

    override fun getPhotosWithOldest(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder(
            oldestPhotosDataSourceFactory,
            PagedList.Config.Builder().setPageSize(5).setMaxSize(15).setEnablePlaceholders(true)
                .build()
        ).build()
    }

    override suspend fun getPhotoWithRandom(): Photo {
        return photoRemoteDataSource.getRandomPhoto()
    }

    override suspend fun getPhotosWithRandom(
        collections: String,
        featured: String,
        userName: String,
        query: String,
        orientation: String,
        count: String
    ): List<Photo> {
        return photoRemoteDataSource.getRandomPhotos(
            collections,
            featured,
            userName,
            query,
            orientation,
            count
        )
    }

    companion object {
        private const val ORDER_POPULAR = "popular"
        private const val ORDER_OLDEST = "oldest"
        private const val ORDER_LATEST = "latest"
    }
}