package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): Flow<List<Task>>
    @Query("SELECT * FROM Task WHERE dueDate <= :time")
    fun getOverdue(time: Long): Flow<List<Task>>

    @Query("SELECT * FROM Task WHERE categoryId = :catId")
    fun getByCategory(catId: Int): Flow<List<Task>>

    @Insert
    suspend fun insert(task: Task)
    @Update
    suspend fun update(task: Task)
    @Delete
    suspend fun delete(task: Task)
}