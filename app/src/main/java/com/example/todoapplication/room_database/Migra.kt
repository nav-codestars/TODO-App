package com.example.todoapplication.room_database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Add the new column with a default value
        database.execSQL("UPDATE todo_table SET id = 0 WHERE id IS NULL")
    }
}