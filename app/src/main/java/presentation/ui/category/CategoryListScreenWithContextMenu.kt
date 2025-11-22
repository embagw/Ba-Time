package presentation.ui.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.embag.batime.data.local.Category
import presentation.ViewModel.CategoryViewModel

@Composable
fun CategoryListScreenWithContextMenu(
    viewModel: CategoryViewModel = hiltViewModel(),
    navController: NavController,
    onViewTasks: (Category) -> Unit,
    onViewSchedules: (Category) -> Unit,
    onViewActivities: (Category) -> Unit,
    onEditCategory: (Category) -> Unit,
    onDeleteCategory: (Category) -> Unit
) {
    val categories by viewModel.categories.collectAsState()
    val tree = remember(categories) { buildTree(categories) }

    var contextCategory by remember { mutableStateOf<Category?>(null) }
    var menuExpanded by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Box(Modifier.fillMaxSize()) {
        ExpandableCategoryTree(
            nodes = tree,
            onItemClick = { /* انتخاب عادی */ },
            onLongPress = { cat ->
                contextCategory = cat
                menuExpanded = true
            }
        )

        // منوی محتوا
        contextCategory?.let { cat ->
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("وظایف متصل") },
                    onClick = {
                        onViewTasks(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.Done, contentDescription = null) })
                DropdownMenuItem(
                    text = { Text("وظایف متصل") },
                    onClick = {
                        onViewTasks(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.Done, contentDescription = null) }
                )
                DropdownMenuItem(
                    text = { Text("زمان‌بندی‌های متصل") },
                    onClick = {
                        onViewSchedules(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) }
                )
                DropdownMenuItem(
                    text = { Text("فعالیت‌های انجام‌شده") },
                    onClick = {
                        onViewActivities(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.Build, contentDescription = null) }
                )
                Divider()
                DropdownMenuItem(
                    text = { Text("ویرایش") },
                    onClick = {
                        onEditCategory(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.Edit, contentDescription = null) }
                )
                DropdownMenuItem(
                    text = { Text("حذف") },
                    onClick = {
                        onDeleteCategory(cat)
                        menuExpanded = false
                    },
                    trailingIcon = { Icon(Icons.Default.Delete, contentDescription = null) }
                )
            }
        }
    }
}