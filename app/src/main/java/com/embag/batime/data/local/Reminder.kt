package com.embag.batime.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity نمایانگر یادآور

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val time: Long,                // timestamp هشدار
    val repeatPattern: String?,    // تکرار بین بازه یا تا تکمیل
    val type: String               // "notification" یا "alarm"
)
