package com.muratcay.remote.mappers

import com.muratcay.data.models.ArticleEntity
import com.muratcay.remote.models.Article
import java.util.UUID
import javax.inject.Inject

class ArticleEntityMapper @Inject constructor(
    private val sourceEntityMapper: SourceEntityMapper
) : EntityMapper<Article, ArticleEntity> {
    override fun mapFromModel(model: Article): ArticleEntity {
        return ArticleEntity(
            id = UUID.randomUUID().hashCode(),
            author = model.author.orEmpty(),
            content = model.content.orEmpty(),
            description = model.description.orEmpty(),
            publishedAt = model.publishedAt.orEmpty(),
            source = sourceEntityMapper.mapFromModel(model.source!!),
            title = model.title.orEmpty(),
            url = model.url.orEmpty(),
            urlToImage = model.urlToImage.orEmpty(),
            isBookMarked = model.isBookMarked
        )
    }
}