package com.example.topheadlinesappcompose.presentation.navigation

import androidx.lifecycle.ViewModel
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _headlinedDetails = MutableStateFlow<TopHeadlinesItem?>(null)
    val headLineItem = _headlinedDetails.asStateFlow()

    fun getHeadlineDetails(topHeadlinesItem: TopHeadlinesItem?){
       _headlinedDetails.value = topHeadlinesItem
    }
}