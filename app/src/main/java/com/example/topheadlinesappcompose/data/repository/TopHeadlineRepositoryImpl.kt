package com.example.topheadlinesappcompose.data.repository

import com.example.topheadlinesappcompose.BuildConfig
import com.example.topheadlinesappcompose.data.remote.ApiService
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.domain.repository.TopHeadlineRepository
import com.example.topheadlinesappcompose.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): TopHeadlineRepository {

    override fun getTopHeadlines(sources: String): Flow<Resource<List<TopHeadlinesItem>?>> {
       return flow<Resource<List<TopHeadlinesItem>?>>{
           val response = apiService.getTopHeadlines(sources, BuildConfig.API_KEY)
           emit(Resource.Success(response.articles?.map {
               TopHeadlinesItem(
                   it?.author,
                   it?.title,
                   it?.description,
                   it?.urlToImage,
                   it?.publishedAt,
                   it?.content) }))
       }.flowOn(Dispatchers.IO)
           .catch {
               emit(Resource.Error(it))
           }
    }
}