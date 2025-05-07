package com.embag.batime.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity نمایانگر زمان‌بندی
// می‌تواند به چند Task متصل شود
@Entity
data class Schedule(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,                // "hour_range","day_range","pomodoro"...
    val startTime: Long,             // timestamp
    val endTime: Long?,              // timestamp or null
    val repeat: String?,             // "daily","weekly" or null
    val categoryId: Int              // id of Category
)
