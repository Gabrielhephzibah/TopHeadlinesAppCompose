package com.example.topheadlinesappcompose.presentation.topHeadlinesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topheadlinesappcompose.data.remote.dto.TopHeadlinesResponse

import com.example.topheadlinesappcompose.domain.repository.TopHeadlineRepository
import com.example.topheadlinesappcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
//import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TopHeadlineViewModel @Inject constructor(
   private val repository: TopHeadlineRepository
): ViewModel() {

    val getTopHeadlines = repository.getTopHeadlines("bbc-news").shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),

    )

//
//    fun getTopHeadlines(source:String) : StateFlow<Resource<TopHeadlinesResponse>> =
//        repository
//        .getTopHeadlines(source)
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = Resource.Loading
//        )

}