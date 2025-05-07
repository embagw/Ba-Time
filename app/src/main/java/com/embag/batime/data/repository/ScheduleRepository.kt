package com.embag.batime.data.repository

import com.embag.batime.data.local.Schedule
import com.embag.batime.data.local.ScheduleDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScheduleRepository @Inject constructor(private val dao: ScheduleDao) {
    fun getAll(): Flow<List<Schedule>> = dao.getAll()
    suspend fun add(s: Schedule) = dao.insert(s)
}