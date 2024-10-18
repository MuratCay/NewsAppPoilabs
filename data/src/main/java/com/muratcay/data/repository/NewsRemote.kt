package com.muratcay.data.repository

import com.muratcay.data.models.ArticleEntity

interface NewsRemote {
    suspend fun getArticles(): List<ArticleEntity>
    suspend fun getArticleById(id: Long): ArticleEntity
}