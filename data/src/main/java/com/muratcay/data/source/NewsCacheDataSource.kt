package com.muratcay.data.source

import com.muratcay.data.models.ArticleEntity
import com.muratcay.data.repository.NewsCache
import com.muratcay.data.repository.NewsDataSource
import javax.inject.Inject

class NewsCacheDataSource @Inject constructor(
    private val newsCache: NewsCache
) : NewsDataSource {

    override suspend fun getArticles(): List<ArticleEntity> {
        return newsCache.getArticles()
    }

    override suspend fun getArticleById(id: Long): ArticleEntity {
        return newsCache.getArticleById(id)
    }

    override suspend fun saveArticles(articles: List<ArticleEntity>) {
        return newsCache.saveArticles(articles)
    }

    override suspend fun getBookMarkedArticles(): List<ArticleEntity> {
        return newsCache.getBookMarkedArticles()
    }

    override suspend fun setArticleBookMarked(id: Long): Int {
        return newsCache.setNewsBookMarked(id)
    }

    override suspend fun setArticleUnBookMarked(id: Long): Int {
        return newsCache.setNewsUnBookMarked(id)
    }

    override suspend fun isCached(): Boolean {
        return newsCache.isCached()
    }
}