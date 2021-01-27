package com.example.webapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class News(
    @SerializedName("title")
    val newsTitle: String,
    @SerializedName("url")
    val url: String
): Parcelable