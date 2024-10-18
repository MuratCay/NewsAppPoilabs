package com.muratcay.data.source

import com.muratcay.data.repository.NewsCache
import com.muratcay.data.repository.NewsDataSource
import javax.inject.Inject

open class NewsDataSourceFactory @Inject constructor(
    private val newsCache: NewsCache,
    private val newsCacheDataSource: NewsCacheDataSource,
    private val newsRemoteDataSource: NewsRemoteDataSource
) {
    open suspend fun getDataStore(isCached: Boolean): NewsDataSource {
        return if (isCached && !newsCache.isExpired()) {
            getCacheDataStore()
        } else {
            getRemoteDataStore()
        }
    }

    fun getCacheDataStore(): NewsDataSource {
        return newsCacheDataSource
    }

    fun getRemoteDataStore(): NewsDataSource {
        return newsRemoteDataSource
    }
}