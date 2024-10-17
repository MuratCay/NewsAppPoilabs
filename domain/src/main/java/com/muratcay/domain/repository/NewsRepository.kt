package com.muratcay.domain.repository

import com.muratcay.domain.Result
import com.muratcay.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    //Remote and cache
    suspend fun getBreakingNews(): Flow<Result<List<Article>>>
    suspend fun getNews(id: Long): Flow<Result<Article>>

    //Cache only
    suspend fun saveArticles(articles: List<Article>)
    suspend fun getBookmarkedNews(): Flow<Result<List<Article>>>
    suspend fun setArticleBookmark(articleId: Long): Flow<Int>
    suspend fun setArticleUnBookmark(articleId: Long): Flow<Int>
}