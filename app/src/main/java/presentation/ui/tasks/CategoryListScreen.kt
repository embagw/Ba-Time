package presentation.ui.tasks


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.embag.batime.data.local.Category
import presentation.ViewModel.CategoryViewModel
import presentation.ViewModel.TaskViewModel


// نمایش لیست دسته‌بندی‌ها و دکمه افزودن

@Composable
fun CategoryListScreen(
    navController: NavHostController,
    viewModel: CategoryViewModel = hiltViewModel(),
    onAddClick: () -> Unit,
    onEditClick: (Category) -> Unit
) {
    val categories by viewModel.categories.collectAsState()

    Scaffold (
        floatingActionButton = {
            FloatingActionButton (onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(categories) { category ->
                CategoryItem(
                    category = category,
                    onClick = { onEditClick(category) },
                    onDelete = { viewModel.deleteCategory(category) }
                )
            }
        }
        Button(onClick = { navController.navigate("add_category") }) {
            Text("افزودن دسته‌بندی جدید")
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(Color(category.color))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(category.name, modifier = Modifier.weight(1f))
        IconButton (onClick = onDelete) {
            Icon(Icons.Default.Delete, contentDescription = "حذف")
        }
    }
}