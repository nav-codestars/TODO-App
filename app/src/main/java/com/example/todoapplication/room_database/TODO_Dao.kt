package com.example.todoapplication.room_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TODO_Dao {
    @Upsert
    suspend fun insert(todoItem: TODOItem)

    @Delete
    suspend fun delete(todoItem: TODOItem)

    @Query("SELECT * FROM todo_table")
    fun getAll(): Flow<List<TODOItem>>

}