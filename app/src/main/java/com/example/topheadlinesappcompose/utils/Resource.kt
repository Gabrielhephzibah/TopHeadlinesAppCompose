package com.example.topheadlinesappcompose.utils

sealed class Resource<out T>(
     val data: T? = null,
   val error: Throwable? = null
) {
    data class Success<T>( val mdata: T): Resource<T>(data = mdata)
    data class Error(val merror : Throwable? = null):Resource<Nothing>(error = merror)
    object Loading: Resource<Nothing>()
}