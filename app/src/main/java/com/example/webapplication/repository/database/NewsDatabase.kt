package com.example.webapplication.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
@TypeConverters(NewsTypeConverters::class)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): newsDao
}