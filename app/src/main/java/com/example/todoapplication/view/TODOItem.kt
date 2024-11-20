package com.example.todoapplication.view

import android.R.attr.enabled
import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import coil3.Image
import coil3.compose.AsyncImage
import com.example.todoapplication.room_database.TODOItem
import com.example.todoapplication.R
import java.nio.file.WatchEvent

@Composable
fun TODOItem(
    todoItem: TODOItem,
    deleteTodo:(TODOItem)-> Unit,
    navigate:(String)->Unit
) {
    val iconSIze = 35.dp
    Card(
        modifier = Modifier.padding(2.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD7D7D7))
    ) {

        Row(
            modifier = Modifier
                .padding(1.dp)
                .background(Color(0xFFFFFFFF))
                .fillMaxWidth(0.95f)
                .padding(10.dp,20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(0.2f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = todoItem.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(iconSIze)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.6f)
                    .clickable(
                        enabled = true,
                        onClick = {
                            navigate("view/${todoItem.id}")
                        }
                    ),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = todoItem.title,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier.weight(0.2f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = R.drawable.delete_svgrepo_com,
                    contentDescription = null,
                    modifier = Modifier
                        .size(iconSIze)
                        .clickable(
                            enabled = true,
                            onClick = {
                                deleteTodo(todoItem)
                            }
                        )
                )
            }
        }
    }
}
