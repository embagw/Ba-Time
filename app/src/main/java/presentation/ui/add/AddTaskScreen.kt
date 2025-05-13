package presentation.ui.add

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.embag.batime.data.local.Task
import presentation.ViewModel.TaskViewModel


@Composable
fun AddTaskScreen(
    navController: NavController,
    vm: TaskViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("افزودن وظیفه جدید", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("عنوان") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("توضیح") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(onClick = {
            val newTask = Task(
                title = title,
                description = description,
                priority = 0,
                dueDate = null,
                categoryId = 1
            )
            vm.add(newTask)
            navController.popBackStack() // بازگشت به صفحه قبل
        }) {
            Text("ذخیره")
        }
    }
}
