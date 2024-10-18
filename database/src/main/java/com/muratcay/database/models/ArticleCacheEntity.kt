package com.muratcay.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muratcay.database.utils.CacheConstants

@Entity(tableName = CacheConstants.ARTICLE_TABLE_NAME)
data class ArticleCacheEntity(
    @PrimaryKey
    val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    @Embedded
    val source: SourceCacheEntity,
    val title: String,
    val url: String,
    val urlToImage: String,
    @ColumnInfo(name = "is_bookmarked")
    var isBookMarked: Boolean
)
