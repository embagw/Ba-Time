package presentation.ui.add

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.embag.batime.data.local.Task
import presentation.ViewModel.TaskViewModel


@Composable
fun AddEditTaskScreen(
    navController: NavController,
    taskId: Int? = null,              // اگر null باشد یعنی «افزودن»
    categoryId: Int,                  // دسته‌بندی جاری
    vm: TaskViewModel = hiltViewModel()
) {
    // ۱. بارگذاری لیست یا تک تسک بر اساس taskId
    val tasks by vm.tasks.collectAsState()
    val existing = taskId?.let { id -> tasks.find { it.id == id } }

    var title by remember { mutableStateOf(existing?.title ?: "") }
    var description by remember { mutableStateOf(existing?.description ?: "") }

    Column(Modifier.padding(16.dp)) {
        Text(
            if (existing == null) "افزودن وظیفه جدید" else "ویرایش وظیفه",
            style = MaterialTheme.typography.headlineSmall
        )

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

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            val t = Task(
                id = existing?.id ?: 0,
                title = title,
                description = description,
                priority = existing?.priority ?: 0,
                dueDate = existing?.dueDate,
                categoryId = categoryId
            )
            if (existing == null) vm.add(t) else vm.update(t)
            navController.popBackStack()
        }) {
            Text(if (existing == null) "ذخیره" else "بروزرسانی")
        }
    }
}
