package com.embag.batime.data.repository

import com.embag.batime.data.local.Activity
import com.embag.batime.data.local.ActivityDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActivityRepository @Inject constructor(private val dao: ActivityDao) {
    fun getAll(): Flow<List<Activity>> = dao.getAll()
    suspend fun add(a: Activity) = dao.insert(a)
}