package com.example.webapplication.viewmodel

import android.app.Application
import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.webapplication.model.Article
import com.example.webapplication.repository.Repository
import com.example.webapplication.repository.database.NewsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
        application: Application,
        private val repository: Repository
): AndroidViewModel(application) {

    var readArticle: LiveData<NewsEntity> = repository.readArticle()

    fun getNews(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val article = repository.getNews(query).body()
            if (article != null) {
                repository.clearAndInsertArticle(NewsEntity(article = article))
            }
        }
    }
}