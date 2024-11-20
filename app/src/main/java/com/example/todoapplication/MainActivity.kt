package com.example.todoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapplication.room_database.TODOItem
import com.example.todoapplication.ui.theme.TODOApplicationTheme
import com.example.todoapplication.view.TODOCreate
import com.example.todoapplication.view.TODOItem
import com.example.todoapplication.view.TODOList
import com.example.todoapplication.view.TODOView
import com.example.todoapplication.view.TODOViewModel

class MainActivity : ComponentActivity() {
    var vm = viewModels<TODOViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOApplicationTheme {
                var NavHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        Row(
                            modifier = Modifier
                                .background(Color.White)
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.list_check_svgrepo_com),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                                    .clickable(
                                        enabled = true,
                                        onClick = {
                                            NavHostController.navigate("list")
                                        }
                                    )
                            )
                            Icon(
                                painter = painterResource(R.drawable.create_svgrepo_com),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                                    .clickable(
                                        enabled = true,
                                        onClick = {
                                            NavHostController.navigate("create")
                                        }
                                    )
                            )
                        }
                    }
                ) { innerPadding ->
                    val todos = vm.value.todos.collectAsState(listOf()).value


                    NavHost(
                        navController = NavHostController,
                        startDestination = "list",
                        modifier = Modifier.fillMaxWidth(),
                    ) {

                        var navigate:(String)->Unit = { dest ->
                            NavHostController.navigate(dest)
                        }
                        composable("list") {
                            Column(
                                modifier = Modifier.fillMaxSize().padding(top = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                            TODOList(todos, vm.value::deleteTodo, navigate)
                            }
                        }
                        composable("create") {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                TODOCreate(vm.value::addTodo, navigate)
                            }
                        }
                        composable(
                           "view/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ){backstackentry ->

                                TODOView(todos.find { it.id == backstackentry.arguments?.getInt("id") }!!,navigate)
                        }
                    }
                }
            }
        }
    }
}