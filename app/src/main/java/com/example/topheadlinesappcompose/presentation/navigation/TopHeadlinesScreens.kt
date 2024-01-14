package com.example.topheadlinesappcompose.presentation.navigation

enum class TopHeadlinesScreens(route: String) {
    HeadLineList("headlineScreen"),
    HeadLineDetails("HeadLineDetails" + "?{title}" + "?{description}" + "?{description}" + "/{content}" + "?{imageUrl}")
}