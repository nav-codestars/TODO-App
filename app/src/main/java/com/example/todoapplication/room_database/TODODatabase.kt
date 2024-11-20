package com.example.todoapplication.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TODOItem::class],
    version = 2
)
abstract class TODODatabase: RoomDatabase() {
    abstract fun todoDao(): TODO_Dao

    companion object {
        var INSTANCE: TODODatabase? = null


    fun getInstance(context: Context): TODODatabase {
        if (INSTANCE == null) {
            synchronized(TODODatabase::class)
            {
                INSTANCE = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    TODODatabase::class.java,
                    "todo_database"
                ).addMigrations(MIGRATION_1_2)
                    .build()
            }
        }
        return INSTANCE!!
    }
    }
}