package com.muratcay.data.models

data class ArticleEntity(
    val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceEntity,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isBookMarked: Boolean
)