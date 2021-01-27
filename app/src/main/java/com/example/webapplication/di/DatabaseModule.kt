package com.example.webapplication.di

import android.content.Context
import androidx.room.Room
import com.example.webapplication.repository.database.NewsDatabase
import com.example.webapplication.repository.database.newsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "news_database.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(
        newsDatabase: NewsDatabase
    ): newsDao {
        return newsDatabase.newsDao()
    }
}