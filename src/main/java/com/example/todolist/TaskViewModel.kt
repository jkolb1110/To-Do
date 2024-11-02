package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao: TaskDao = TaskDatabase.getDatabase(application).taskDao()
    val taskItems: LiveData<List<TaskItem>> = taskDao.getAllTasks()

    fun addTaskItem(taskItem: TaskItem) {
        viewModelScope.launch {
            taskDao.insertTask(taskItem)
        }
    }

    fun updateTaskItem(id: String, name: String, desc: String, dueTime: LocalTime?) {
        viewModelScope.launch {
            val task = taskDao.getTaskById(id)
            task.name = name
            task.desc = desc
            task.dueTime = dueTime
            taskDao.updateTask(task)
        }
    }

    fun deleteTaskItem(taskItem: TaskItem) {
        viewModelScope.launch {
            taskDao.deleteTask(taskItem)
        }
    }

    fun setCompleted(taskItem: TaskItem) {
        viewModelScope.launch {
            taskItem.completedDate = LocalDate.now()
            taskDao.updateTask(taskItem)
        }
    }
}