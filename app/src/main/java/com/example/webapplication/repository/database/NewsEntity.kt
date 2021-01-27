package com.example.webapplication.repository.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.webapplication.model.Article

@Entity(tableName = "news_table")
class NewsEntity(
    var article: Article
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}