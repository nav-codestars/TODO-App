package com.example.todoapplication.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapplication.room_database.TODOItem

@Composable
fun TODOView(todoItem: TODOItem, navigate:(String)->Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.9f)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = todoItem.title,
            fontSize = 20.sp,
            color = Color.Black
        )
        Text(
            text = todoItem.description,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Date: ${todoItem.date}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Text(
            text = "Time: ${todoItem.time}",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
        Button(
            onClick = {
                navigate("list")
            }
        ) {
            Text("View todo's")
        }
    }
}