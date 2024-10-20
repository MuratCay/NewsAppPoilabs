package com.muratcay.newsapppoilabs.di

import android.content.Context
import androidx.room.Room
import com.muratcay.data.repository.NewsCache
import com.muratcay.database.ArticleCacheImpl
import com.muratcay.database.dao.ArticleDao
import com.muratcay.database.db.NewsDatabase
import com.muratcay.database.utils.CacheConstants
import com.muratcay.database.utils.CachePreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, CacheConstants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(newsDatabase: NewsDatabase): ArticleDao {
        return newsDatabase.articleDao()
    }

    @Singleton
    @Provides
    fun provideArticleCache(articleCacheImpl: ArticleCacheImpl): NewsCache {
        return articleCacheImpl
    }

    @Singleton
    @Provides
    fun provideCachePreferencesHelper(@ApplicationContext context: Context): CachePreferencesHelper {
        return CachePreferencesHelper(context)
    }
}