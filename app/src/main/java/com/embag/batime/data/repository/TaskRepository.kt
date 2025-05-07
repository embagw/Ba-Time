package com.embag.batime.data.repository

import com.embag.batime.data.local.Task
import com.embag.batime.data.local.TaskDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(private val dao: TaskDao) {
    fun getAll(): Flow<List<Task>> = dao.getAll()
    fun getOverdue(time: Long): Flow<List<Task>> = dao.getOverdue(time)
    suspend fun add(task: Task) = dao.insert(task)
}