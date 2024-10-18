package com.muratcay.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muratcay.database.dao.ArticleDao
import com.muratcay.database.models.ArticleCacheEntity
import com.muratcay.database.models.SourceCacheEntity

@Database(
    entities = [ArticleCacheEntity::class, SourceCacheEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}