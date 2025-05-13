package presentation.ui.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.embag.batime.data.local.Category
import presentation.ViewModel.CategoryViewModel

@Composable
fun AddEditCategoryScreen(
    navController: NavController,
    categoryId: Int? = null,
    vm: CategoryViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Red.toArgb().toLong()) }

    val isEdit = categoryId != null
    val categories by vm.categories.collectAsState()

    val existingCategory = categories.find { it.id == categoryId }

    LaunchedEffect(categoryId) {
        existingCategory?.let {
            name = it.name
            color = it.color
        }
    }

    Column (Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("نام دسته‌بندی") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                val category = Category(
                    id = categoryId ?: 0,
                    name = name,
                    color = color
                )
                if (isEdit) vm.updateCategory(category) else vm.addCategory(category)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("ذخیره")
        }

        if (isEdit) {
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {
                    existingCategory?.let {
                        vm.deleteCategory(it)
                        navController.popBackStack()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("حذف")
            }
        }
    }
}
