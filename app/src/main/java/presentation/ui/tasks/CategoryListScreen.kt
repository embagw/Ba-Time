package presentation.ui.tasks


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import presentation.ViewModel.CategoryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


// نمایش لیست دسته‌بندی‌ها و دکمه افزودن

@Composable
fun CategoryListScreen(vm: CategoryViewModel = viewModel()) {
    val list = vm.categories.collectAsState().value
    Column {
        LazyColumn {
            items(list) { cat ->
                Text(text = cat.name, modifier = Modifier.clickable() { /* ویرایش */ })
            }
        }
        Button (onClick = { vm.addCategory("جدید", 0xFF0000) }) {
            Text("افزودن دسته‌بندی")
        }
    }
}