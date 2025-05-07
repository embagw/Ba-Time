package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM Schedule")
    fun getAll(): Flow<List<Schedule>>
    @Insert suspend fun insert(s: Schedule)
}