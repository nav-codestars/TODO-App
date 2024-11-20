package com.example.todoapplication.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.todoapplication.room_database.TODOItem

@Composable
fun TODOList(todos: List<TODOItem>, deleteTodo:(TODOItem)-> Unit, navigate:(String)->Unit)
{
    LazyColumn {
        items(todos.size)
        {
            TODOItem(todos[it], deleteTodo,navigate )
        }
    }
}