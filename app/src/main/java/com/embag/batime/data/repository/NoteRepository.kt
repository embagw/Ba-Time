package com.embag.batime.data.repository

import com.embag.batime.data.local.Note
import com.embag.batime.data.local.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject






class NoteRepository @Inject constructor(private val dao: NoteDao) {
    fun getAll(): Flow<List<Note>> = dao.getAll()
    suspend fun add(note: Note) = dao.insert(note)
}