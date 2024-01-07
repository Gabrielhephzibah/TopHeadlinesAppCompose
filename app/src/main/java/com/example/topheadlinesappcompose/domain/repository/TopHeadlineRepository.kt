package com.example.topheadlinesappcompose.domain.repository

import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.utils.Resource
import kotlinx.coroutines.flow.Flow

interface TopHeadlineRepository {
    fun getTopHeadlines(sources: String) : Flow<Resource<List<TopHeadlinesItem>?>>
}