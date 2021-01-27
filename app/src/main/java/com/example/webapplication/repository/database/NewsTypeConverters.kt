package com.example.webapplication.repository.database

import androidx.room.TypeConverter
import com.example.webapplication.model.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun articlesToString(article: Article): String {
        return gson.toJson(article)
    }

    @TypeConverter
    fun stringToArticle(json: String): Article {
        val listType = object : TypeToken<Article>() {}.type
        return  gson.fromJson(json, listType)
    }
}