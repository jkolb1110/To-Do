package com.example.todolist

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime

class Converters {

    @TypeConverter
    fun fromLocalTime(time: LocalTime?): String? {
        return time?.toString()
    }

    @TypeConverter
    fun toLocalTime(time: String?): LocalTime? {
        return if (time == null) null else LocalTime.parse(time)
    }

    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun toLocalDate(date: String?): LocalDate? {
        return if (date == null) null else LocalDate.parse(date)
    }

}
