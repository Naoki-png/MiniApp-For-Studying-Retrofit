package com.example.webapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.webapplication.model.Article
import com.example.webapplication.repository.database.NewsDatabase
import com.example.webapplication.repository.database.NewsEntity
import com.example.webapplication.repository.database.newsDao
import com.example.webapplication.repository.network.NewsService
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
        @ApplicationContext context: Context,
        private val newsService: NewsService,
        private val newsDao: newsDao
) {
    suspend fun getNews(searchString: String): Response<Article> {
        return newsService.getNews(searchString)
    }

    fun readArticle(): LiveData<NewsEntity> {
        return newsDao.readArticle()
    }

    suspend fun clearAndInsertArticle(newsEntity: NewsEntity) {
        newsDao.clearAndInsertArticle(newsEntity)
    }
}