package com.embag.batime.data.di

import android.content.Context
import androidx.room.Room
import com.embag.batime.data.local.*
import com.embag.batime.data.repository.CategoryRepository
import com.embag.batime.data.repository.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideActivityDao(db: AppDatabase): ActivityDao = db.activityDao()

    @Singleton
    @Provides
    fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

    @Singleton
    @Provides
    fun provideReminderDao(db: AppDatabase): ReminderDao = db.reminderDao()

    @Singleton
    @Provides
    fun provideScheduleDao(db: AppDatabase): ScheduleDao = db.scheduleDao()

    @Singleton
    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao()

    @Singleton
    @Provides
    fun provideCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao()

    @Singleton
    @Provides
    fun provideCategoryRepository(dao: CategoryDao): CategoryRepository {
        return CategoryRepositoryImpl(dao)
    }
}

