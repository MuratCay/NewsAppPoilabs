package com.muratcay.data.mapper

import com.muratcay.data.models.ArticleEntity
import com.muratcay.domain.models.Article
import javax.inject.Inject

class ArticleMapper @Inject constructor(
    private val sourceMapper: SourceMapper
) : Mapper<ArticleEntity, Article> {
    override fun mapFromEntity(type: ArticleEntity): Article {
        return Article(
            type.id,
            type.author,
            type.content,
            type.description,
            type.publishedAt,
            sourceMapper.mapFromEntity(type.source),
            type.title,
            type.url,
            type.urlToImage,
            type.isBookMarked
        )
    }

    override fun mapToEntity(type: Article): ArticleEntity {
        return ArticleEntity(
            type.id,
            type.author,
            type.content,
            type.description,
            type.publishedAt,
            sourceMapper.mapToEntity(type.source),
            type.title,
            type.url,
            type.urlToImage,
            type.isBookMarked
        )
    }
}