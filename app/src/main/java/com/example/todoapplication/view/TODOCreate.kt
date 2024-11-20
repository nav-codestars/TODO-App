package com.example.todoapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todoapplication.room_database.TODOItem
import com.example.todoapplication.R
import java.util.Calendar


@Composable
fun TODOCreate(addTodo:(TODOItem)->Unit, navigate:(String)-> Unit)
{
    var icon by remember { mutableStateOf(0) }
    var size = 40.dp
    var text by remember { mutableStateOf("") }
    var desc by remember {  mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(0.9f)
            .padding(10.dp)
    ) {


        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Task") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        OutlinedTextField(
            value = desc,
            onValueChange = { desc = it },
            label = { Text("Description") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        Row(
            modifier = Modifier.padding(0.dp,10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.software_update_urgent_svgrepo_com),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(size)
                    .background(
                        if(icon==0) Color.Gray else Color.White
                    )
                    .padding(5.dp)
                    .clickable(
                        onClick = {
                            icon = 0
                        }
                    ),
            )
            Image(
                painter = painterResource(R.drawable.important_svgrepo_com),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(size)
                    .background(
                        if(icon==1) Color.Gray else Color.White
                    )
                    .padding(5.dp)
                    .clickable(
                        onClick = {
                            icon = 1
                        }
                    ),
            )
            Image(
                painter = painterResource(R.drawable.hourglass_svgrepo_com),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(size)
                    .background(
                        if(icon==2) Color.Gray else Color.White
                    )
                    .padding(5.dp)
                    .clickable(
                        onClick = {
                            icon = 2
                        }
                    ),
            )
        }

        var cal = Calendar.getInstance()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier.padding(0.dp, 10.dp),
                onClick = {
                    addTodo(
                        TODOItem(
                            title = text,
                            description = desc,
                            icon = intArrayOf(
                                R.drawable.software_update_urgent_svgrepo_com,
                                R.drawable.important_svgrepo_com,
                                R.drawable.hourglass_svgrepo_com
                            )[icon],
                            date = "${cal.get(Calendar.AM_PM)}|${cal.get(Calendar.DAY_OF_MONTH)}|${
                                cal.get(
                                    Calendar.YEAR
                                )
                            }",
                            time = "${cal.get(Calendar.HOUR)}:${cal.get(Calendar.MINUTE)}"
                        )
                    )
                }
            ) {
                Text(text = "Add Task")
            }
            Button(
                modifier = Modifier.padding(0.dp, 10.dp),
                onClick = {
                    navigate("list")
                }
            ) {
                Text("View TODO's")
            }
        }
    }

}