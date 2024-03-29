package com.example.walkthroughtodo.ui

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walkthroughtodo.model.Todo
import com.example.walkthroughtodo.ui.theme.WalkthroughToDoTheme
import com.example.walkthroughtodo.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalkthroughToDoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoScreen()
                }
            }
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()){
    TodoList(todoViewModel.todos)
}

@Composable
fun TodoList(todos: List<Todo>)  {
    LazyColumn( modifier = Modifier.padding(8.dp)
    ){
        items(todos) { todo ->
            Text (
                text = todo.title,
                modifier = Modifier.padding(top=4.dp,bottom = 4.dp)
            )
            Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WalkthroughToDoTheme {
        TodoScreen()
    }
}