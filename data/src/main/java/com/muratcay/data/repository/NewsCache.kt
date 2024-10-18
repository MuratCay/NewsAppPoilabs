package com.muratcay.data.repository

import com.muratcay.data.models.ArticleEntity

interface NewsCache {
    suspend fun getArticles(): List<ArticleEntity>
    suspend fun getArticleById(id: Long): ArticleEntity

    suspend fun saveArticles(articles: List<ArticleEntity>)
    suspend fun getBookMarkedArticles(): List<ArticleEntity>

    suspend fun setNewsBookMarked(id: Long): Int
    suspend fun setNewsUnBookMarked(id: Long): Int

    suspend fun isCached(): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
    suspend fun isExpired(): Boolean
}