package com.muratcay.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muratcay.database.models.ArticleCacheEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<ArticleCacheEntity>

    @Query("SELECT * FROM ARTICLES WHERE id = :id")
    suspend fun getArticleById(id: Long): ArticleCacheEntity

    @Query("DELETE FROM articles")
    suspend fun clearArticles(): Int

    @Query("UPDATE articles SET is_bookmarked = 1 WHERE id = :id")
    suspend fun setBookmarkedArticle(id: Long): Int

    @Query("UPDATE articles SET is_bookmarked = 0 WHERE id = :id")
    suspend fun setUnBookmarkedArticles(id: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticle(vararg article: ArticleCacheEntity)
}