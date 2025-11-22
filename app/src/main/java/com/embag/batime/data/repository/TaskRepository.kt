package com.embag.batime.data.repository

import com.embag.batime.data.local.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(catId: Int): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
}