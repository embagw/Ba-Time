package com.embag.batime.data.repository

import androidx.room.Insert
import com.embag.batime.data.local.Category
import com.embag.batime.data.local.CategoryDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


//Repository انتزاع دسترسی ViewModel به داده‌ها
class CategoryRepository @Inject constructor(
    private val dao: CategoryDao
){

//     دریافت تمام دسته‌بندی‌ها
    fun getCategories(): Flow<List<Category>> = dao.getAll()

//    افزودن دسته‌بندی جدید

    suspend fun addCategory(cat: Category) = dao.insert(cat)
}