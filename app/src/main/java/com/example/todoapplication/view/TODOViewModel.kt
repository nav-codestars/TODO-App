package com.example.todoapplication.view

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.room_database.TODODatabase
import com.example.todoapplication.room_database.TODOItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TODOViewModel(application: Application): AndroidViewModel(application) {
    val TodoDataBase = TODODatabase.getInstance(application).todoDao()
    var todos = TodoDataBase.getAll()

    fun addTodo(todoItem: TODOItem)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            TodoDataBase.insert(todoItem)
        }
    }

    fun deleteTodo(todoItem: TODOItem)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            TodoDataBase.delete(todoItem)
        }
    }
}