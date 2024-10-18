package com.muratcay.data.repository

import com.muratcay.data.models.ArticleEntity

interface NewsDataSource {
    // Remote and cache
    suspend fun getArticles(): List<ArticleEntity>
    suspend fun getArticleById(id: Long): ArticleEntity

    // Cache
    suspend fun saveArticles(articles: List<ArticleEntity>)
    suspend fun getBookMarkedArticles(): List<ArticleEntity>
    suspend fun setArticleBookMarked(id: Long): Int
    suspend fun setArticleUnBookMarked(id: Long): Int
    suspend fun isCached(): Boolean
}