package com.muratcay.database.mapper

import com.muratcay.data.models.ArticleEntity
import com.muratcay.database.models.ArticleCacheEntity
import javax.inject.Inject

class ArticleCacheMapper @Inject constructor(
    private val sourceCacheMapper: SourceCacheMapper
) : CacheMapper<ArticleCacheEntity, ArticleEntity> {
    override fun mapFromCached(type: ArticleCacheEntity): ArticleEntity {
        return ArticleEntity(
            id = type.id,
            author = type.author,
            content = type.content,
            description = type.description,
            publishedAt = type.publishedAt,
            source = sourceCacheMapper.mapFromCached(type.source),
            title = type.title,
            url = type.url,
            urlToImage = type.urlToImage,
            isBookMarked = type.isBookMarked
        )
    }

    override fun mapToCached(type: ArticleEntity): ArticleCacheEntity {
        return ArticleCacheEntity(
            id = type.id,
            author = type.author,
            content = type.content,
            description = type.description,
            publishedAt = type.publishedAt,
            source = sourceCacheMapper.mapToCached(type.source),
            title = type.title,
            url = type.url,
            urlToImage = type.urlToImage,
            isBookMarked = type.isBookMarked
        )
    }
}