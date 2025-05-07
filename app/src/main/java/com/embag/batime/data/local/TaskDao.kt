package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): Flow<List<Task>>
    @Query("SELECT * FROM Task WHERE dueDate <= :time")
    fun getOverdue(time: Long): Flow<List<Task>>
    @Insert suspend fun insert(task: Task)
}