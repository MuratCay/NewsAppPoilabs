package com.muratcay.remote.repository

import com.muratcay.data.models.ArticleEntity
import com.muratcay.data.repository.NewsRemote
import com.muratcay.remote.api.NewsAppService
import com.muratcay.remote.mappers.ArticleEntityMapper
import javax.inject.Inject

class NewsRemoteImpl @Inject constructor(
    private val newsAppService: NewsAppService,
    private val articleEntityMapper: ArticleEntityMapper
) : NewsRemote {

    override suspend fun getArticles(): List<ArticleEntity> {
        val articles = newsAppService.getBreakingNews().articles
        return articles?.map { article ->
            articleEntityMapper.mapFromModel(article ?: return emptyList())
        } ?: emptyList()
    }

    override suspend fun getArticleById(id: Long): ArticleEntity {
        TODO("Not yet implemented")
    }
}