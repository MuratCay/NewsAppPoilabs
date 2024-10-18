package com.muratcay.data.source

import com.muratcay.data.models.ArticleEntity
import com.muratcay.data.repository.NewsDataSource
import com.muratcay.data.repository.NewsRemote
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
    private val newsRemote: NewsRemote
) : NewsDataSource {

    override suspend fun getArticles(): List<ArticleEntity> {
        return newsRemote.getArticles()
    }

    override suspend fun getArticleById(id: Long): ArticleEntity {
        return newsRemote.getArticleById(id)
    }

    override suspend fun saveArticles(articles: List<ArticleEntity>) {
        throw UnsupportedOperationException("Save article is not supported for RemoteDataSource.")
    }

    override suspend fun getBookMarkedArticles(): List<ArticleEntity> {
        throw UnsupportedOperationException("Get bookmark articles is not supported for RemoteDataSource.")
    }

    override suspend fun setArticleBookMarked(id: Long): Int {
        throw UnsupportedOperationException("Set bookmark article is not supported for RemoteDataSource.")
    }

    override suspend fun setArticleUnBookMarked(id: Long): Int {
        throw UnsupportedOperationException("Set UnBookmark article is not supported for RemoteDataSource.")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }
}