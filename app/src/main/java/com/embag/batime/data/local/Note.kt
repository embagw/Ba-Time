package com.embag.batime.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//* Entity نمایانگر یادداشت

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String?,
    val categoryId: Int            // id of Category
)
