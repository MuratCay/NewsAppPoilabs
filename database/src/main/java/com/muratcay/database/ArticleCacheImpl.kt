package com.muratcay.database

import com.muratcay.data.models.ArticleEntity
import com.muratcay.data.repository.NewsCache
import com.muratcay.database.dao.ArticleDao
import com.muratcay.database.mapper.ArticleCacheMapper
import com.muratcay.database.utils.CachePreferencesHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleCacheImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val articleCacheMapper: ArticleCacheMapper,
    private val preferencesHelper: CachePreferencesHelper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : NewsCache {

    override suspend fun getArticles(): List<ArticleEntity> = withContext(ioDispatcher) {
        return@withContext articleDao.getArticles().map {
            articleCacheMapper.mapFromCached(it)
        }
    }

    override suspend fun getArticleById(id: Long): ArticleEntity = withContext(ioDispatcher) {
        return@withContext articleCacheMapper.mapFromCached(articleDao.getArticleById(id))
    }

    override suspend fun saveArticles(articles: List<ArticleEntity>) = withContext(ioDispatcher) {
        articleDao.addArticle(*articles.map { articleCacheMapper.mapToCached(it) }.toTypedArray())
    }

    override suspend fun getBookMarkedArticles(): List<ArticleEntity> = withContext(ioDispatcher) {
        return@withContext articleDao.getArticles().map {
            articleCacheMapper.mapFromCached(it)
        }
    }

    override suspend fun setNewsBookMarked(id: Long): Int {
        return articleDao.setBookmarkedArticle(id)
    }

    override suspend fun setNewsUnBookMarked(id: Long): Int {
        return articleDao.setUnBookmarkedArticles(id)
    }

    override suspend fun isCached(): Boolean = withContext(ioDispatcher) {
        return@withContext articleDao.getArticles().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

    companion object {
        const val EXPIRATION_TIME = (60 * 5 * 1000).toLong()
    }
}