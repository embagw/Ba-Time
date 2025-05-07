package com.embag.batime.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {
    @Query("SELECT * FROM Activity")
    fun getAll(): Flow<List<Activity>>
    @Insert suspend fun insert(a: Activity)
}