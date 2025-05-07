package com.embag.batime.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Category::class,
        Task::class,
        Schedule::class,
        Activity::class,
        Reminder::class,
        Note::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun categoryDao(): CategoryDao
    abstract fun taskDao(): TaskDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun activityDao(): ActivityDao
    abstract fun reminderDao(): ReminderDao
    abstract fun noteDao(): NoteDao
}