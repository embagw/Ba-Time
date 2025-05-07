package com.embag.batime.data.repository

import com.embag.batime.data.local.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val dao: Note) {
    fun getAll(): Flow<List<Note>> = dao.getAll()
    suspend fun add(n: Note) = dao.insert(n)
}