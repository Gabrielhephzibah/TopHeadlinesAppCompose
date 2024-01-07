package com.example.topheadlinesappcompose.utils.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


//val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
//val outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
//val localDate = LocalDate.parse(this, formatter)
//return outputFormat.format(localDate)

fun String.formatDate(): String{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.ENGLISH)
    val outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
    val localDate = LocalDate.parse(this, formatter)
    return outputFormat.format(localDate)
}

