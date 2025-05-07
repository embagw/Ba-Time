package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Query("SELECT * FROM Reminder")
    fun getAll(): Flow<List<Reminder>>
    @Insert suspend fun insert(r: Reminder)
}