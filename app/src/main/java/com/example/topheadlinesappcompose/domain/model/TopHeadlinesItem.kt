package com.example.topheadlinesappcompose.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopHeadlinesItem(
    val author: String?,
    val title: String?,
    val description: String?,
    val imageUrl: String?,
    val publishedAt: String?,
    val content: String?
): Parcelable
