package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

//     واکشی تمام دسته‌بندی‌ها به‌صورت جریان

    @Query("SELECT * FROM Category")
    fun getAll(): Flow<List<Category>>

//      افزودن دسته‌بندی جدید

    @Insert
    suspend fun insert(cat: Category)
}