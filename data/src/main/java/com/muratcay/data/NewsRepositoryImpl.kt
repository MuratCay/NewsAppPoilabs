package com.muratcay.data

import com.muratcay.data.mapper.ArticleMapper
import com.muratcay.data.source.NewsDataSourceFactory
import com.muratcay.domain.Result
import com.muratcay.domain.models.Article
import com.muratcay.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val dataSourceFactory: NewsDataSourceFactory,
    private val articleMapper: ArticleMapper
) : NewsRepository {

    override suspend fun getNews(): Flow<Result<List<Article>>> {
        val isCached = dataSourceFactory.getCacheDataStore().isCached()
        val articleList = dataSourceFactory.getDataStore(isCached).getArticles().map { articleEntity ->
            articleMapper.mapFromEntity(articleEntity)
        }
        saveArticles(articleList)
        return flow {
            emit(Result.Success(articleList))
        }
    }

    override suspend fun getNewsById(id: Long): Flow<Result<Article>> {
        var article = dataSourceFactory.getCacheDataStore().getArticleById(id)
        if (article.urlToImage.isEmpty()) {
            article = dataSourceFactory.getRemoteDataStore().getArticleById(id)
        }
        return flow {
            emit(Result.Success(articleMapper.mapFromEntity(article)))
        }
    }

    override suspend fun saveArticles(articles: List<Article>) {
        val articleEntities = articles.map { articleMapper.mapToEntity(it) }
        dataSourceFactory.getCacheDataStore().saveArticles(articleEntities)
    }

    override suspend fun getBookmarkedNews(): Flow<Result<List<Article>>> = flow {
        val data = dataSourceFactory.getCacheDataStore().getBookMarkedArticles()
        emit(Result.Success(data.map { articleMapper.mapFromEntity(it) }))
    }

    override suspend fun setArticleBookmark(articleId: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDataStore().setArticleBookMarked(articleId))
    }

    override suspend fun setArticleUnBookmark(articleId: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDataStore().setArticleUnBookMarked(articleId))
    }
}