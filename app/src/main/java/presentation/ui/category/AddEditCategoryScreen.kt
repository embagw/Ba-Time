package presentation.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.embag.batime.data.local.Category
import presentation.ViewModel.CategoryViewModel

@Composable
fun AddEditCategoryScreen(
    category: Category? = null,
    viewModel: CategoryViewModel = hiltViewModel(),
    onSave: () -> Unit
) {
    var name by remember { mutableStateOf(category?.name ?: "") }
    var selectedColor by remember { mutableStateOf(category?.color ?: 0xFF3DDC84) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("نام دسته‌بندی") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("انتخاب رنگ:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        ColorPicker(
            selected = selectedColor,
            onSelect = { selectedColor = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val cat = Category(
                    id = category?.id ?: 0,
                    name = name,
                    color = selectedColor
                )

                if (category == null)
                    viewModel.addCategory(cat)
                else
                    viewModel.updateCategory(cat)

                onSave()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("ذخیره")
        }
    }
}



@Composable
fun ColorPicker(
    selected: Long,
    onSelect: (Long) -> Unit
) {
    val colors = listOf(
        0xFF3DDC84, 0xFFE91E63, 0xFFFFC107, 0xFF2196F3, 0xFF9C27B0, 0xFFFF5722
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(color), shape = MaterialTheme.shapes.medium)
                    .clickable { onSelect(color) }
                    .border(
                        width = if (color == selected) 3.dp else 1.dp,
                        color = if (color == selected) Color.Black else Color.Gray,
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }
    }
}