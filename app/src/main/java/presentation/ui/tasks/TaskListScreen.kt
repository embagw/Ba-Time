package presentation.ui.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import presentation.ViewModel.TaskViewModel


@Composable
fun TaskListScreen(
    navController: NavController,
    categoryId: Int,
    vm: TaskViewModel = hiltViewModel()
) {
    val list by vm.tasks.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                navController.navigate("add_task?categoryId=$categoryId")
            }) {
                navController.navigate("add_task?categoryId=$categoryId")
            }
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            items(list) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("edit_task?taskId=${task.id}") }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(task.title, Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            vm.delete(task)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "حذف وظیفه"
                        )
                    }

                }
            }
        }
    }
}
