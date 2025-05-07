package com.embag.batime.data.dao

//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Query
//import androidx.room.Upsert
//import com.embag.batime.data.entity.TodoEntity
//import kotlinx.coroutines.flow.Flow

//@Dao
//interface TodoDao {
//    @Upsert
//    suspend fun upsert (todoEntity: TodoEntity)
//
//    @Delete
//    suspend fun delete(todoEntity: TodoEntity)
//
//    @Query("SELECT * FROM todos ORDER BY id ASC")
//    fun getAllTodosOrderedById():Flow<List<TodoEntity>>
//
//}