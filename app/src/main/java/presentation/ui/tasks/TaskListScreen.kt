package presentation.ui.tasks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import presentation.ViewModel.TaskViewModel
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun TaskListScreen(
    navController: NavController,
    vm: TaskViewModel = hiltViewModel()
) {
    Button(onClick = { navController.navigate("add_task") }) {
        Text("افزودن وظیفه جدید")
    }
    val list by vm.tasks.collectAsStateWithLifecycle(emptyList())
    LazyColumn { items(list) { t -> Text(t.title) } }

}
