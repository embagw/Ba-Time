package com.embag.batime.data.repository

import com.embag.batime.data.local.NoteDao
import com.embag.batime.data.local.Reminder
import com.embag.batime.data.local.ReminderDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReminderRepository @Inject constructor(private val dao: ReminderDao) {
    fun getAll(): Flow<List<Reminder>> = dao.getAll()
    suspend fun add(r: Reminder) = dao.insert(r)
}