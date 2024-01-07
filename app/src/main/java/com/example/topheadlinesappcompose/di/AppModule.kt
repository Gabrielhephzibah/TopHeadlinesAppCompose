package com.example.topheadlinesappcompose.di

import com.example.topheadlinesappcompose.BuildConfig
import com.example.topheadlinesappcompose.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Singleton
   @Provides
   fun provideHttpLogging(): OkHttpClient{
       val logger = HttpLoggingInterceptor().apply {
           level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
           else
               HttpLoggingInterceptor.Level.NONE
       }

       return OkHttpClient.Builder()
           .addInterceptor(logger)
           .callTimeout(12L, TimeUnit.SECONDS)
           .readTimeout(12L, TimeUnit.SECONDS)
           .writeTimeout(12L,TimeUnit.SECONDS)
           .build()
   }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}