package com.embag.batime.data.repository

import com.embag.batime.data.local.Task
import com.embag.batime.data.local.TaskDao
import javax.inject.Inject






class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
): TaskRepository {
    override fun getTasks(catId: Int) = dao.getByCategory(catId)
    override suspend fun addTask(task: Task) = dao.insert(task)
    override suspend fun updateTask(task: Task) = dao.update(task)
    override suspend fun deleteTask(task: Task) = dao.delete(task)
}