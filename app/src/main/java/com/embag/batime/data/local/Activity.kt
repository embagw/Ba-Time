package com.embag.batime.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity نمایانگر فعالیت انجام‌شده
// می‌تواند به چند Task و Schedule متصل باشد
@Entity
data class Activity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,               // مشابه Schedule types
    val timestamp: Long,            // زمان ثبت فعالیت
    val categoryId: Int             // id of Category
)
