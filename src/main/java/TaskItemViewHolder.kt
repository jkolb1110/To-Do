package com.example.todolist

import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root){

    private val timeFormat = DateTimeFormatter.ofPattern("HH.mm")
    fun bindTaskItem(taskItem: TaskItem)
    {
        binding.name.text = taskItem.name

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(binding.root.context))

        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)

        }
        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }
        binding.deleteButton.setOnClickListener {
            clickListener.deleteTaskItem(taskItem)
        }

        if (taskItem.dueTime != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime)
        else
            binding.dueTime.text = ""

    }
}