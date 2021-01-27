package com.example.webapplication.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("articles")
    val newsList: List<News>
)