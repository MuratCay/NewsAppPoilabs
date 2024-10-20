package com.muratcay.newsapppoilabs.di

import com.muratcay.data.repository.NewsRemote
import com.muratcay.remote.repository.NewsRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideNewsRemote(newsRemoteImpl: NewsRemoteImpl): NewsRemote {
        return newsRemoteImpl
    }
}