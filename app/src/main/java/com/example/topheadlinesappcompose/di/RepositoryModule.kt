package com.example.topheadlinesappcompose.di

import com.example.topheadlinesappcompose.data.repository.TopHeadlineRepositoryImpl
import com.example.topheadlinesappcompose.domain.repository.TopHeadlineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTopHeadLineRepository(topHeadlineRepositoryImpl: TopHeadlineRepositoryImpl): TopHeadlineRepository

}