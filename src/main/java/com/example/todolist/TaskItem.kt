package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID
import android.content.Context
import androidx.core.content.ContextCompat

@Entity(tableName = "tasks")
data class TaskItem(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var desc: String = "",
    var dueTime: LocalTime? = null,
    var completedDate: LocalDate? = null
) {
    fun isCompleted() = completedDate != null
    fun imageResource(): Int = if (isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if (isCompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.purple_500)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)
}