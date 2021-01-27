package com.example.webapplication.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.webapplication.model.Article

@Dao
interface newsDao {

    @Query("SELECT * FROM news_table")
    fun readArticle(): LiveData<NewsEntity>

    @Transaction
    suspend fun clearAndInsertArticle(news: NewsEntity) {
        clearArticle()
        insertArticle(news)
    }

    @Query("DELETE FROM news_table")
    suspend fun clearArticle()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(news: NewsEntity)

}