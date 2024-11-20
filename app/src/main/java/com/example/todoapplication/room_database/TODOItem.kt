package com.example.todoapplication.room_database

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "todo_table",
)
data class TODOItem(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val title: String,
    val description: String,
    @DrawableRes val icon: Int,
    val date: String,
    val time: String
)
