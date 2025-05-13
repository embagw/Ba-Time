package com.embag.batime.data.repository

import com.embag.batime.data.local.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAll(): Flow<List<Category>>
    suspend fun add(category: Category)
    suspend fun update(category: Category)
    suspend fun delete(category: Category)
}