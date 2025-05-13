package com.embag.batime.data.repository

import com.embag.batime.data.local.Category
import com.embag.batime.data.local.CategoryDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao
) : CategoryRepository {
    override fun getAll(): Flow<List<Category>> = dao.getAll()
    override suspend fun add(category: Category) = dao.insert(category)
    override suspend fun update(category: Category) = dao.update(category)
    override suspend fun delete(category: Category) = dao.delete(category)
}