package com.example.webapplication.repository.network

import com.example.webapplication.model.Article
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface NewsService {

    companion object {
        const val BASE_URL = "http://newsapi.org/v2/"
        const val API_KEY = "2d99388d425a4094ba3130197cdb621b"
    }

    @GET("everything")
    suspend fun getNews(
        @Query("q") searchString: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<Article>
}