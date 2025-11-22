package presentation.ui.category

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
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
import com.embag.batime.data.local.Category
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableCategoryTree(
    nodes: List<CategoryNode>,
    level: Int = 0,
    onItemClick: (Category) -> Unit,
    onLongPress: (Category) -> Unit
) {
    Column {
        nodes.forEach { node ->
            var expanded by remember { mutableStateOf(false) }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (level * 16).dp, top = 4.dp, bottom = 4.dp)
                    .combinedClickable(                   // لمس طولانی برای منوی محتوا
                        onClick = { onItemClick(node.category) },
                        onLongClick = { onLongPress(node.category) }
                    )
            ) {
                Icon(
                    imageVector = if (node.children.isEmpty()) Icons.Default.Menu
                    else if (expanded) Icons.Default.KeyboardArrowDown
                    else Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
                Spacer(Modifier.width(8.dp))
                Text(node.category.name)
                Spacer(Modifier.weight(1f))
                Box(
                    Modifier
                        .size(12.dp)
                        .background(Color(node.category.color), shape = CircleShape)
                )
            }

            if (expanded) {
                ExpandableCategoryTree(
                    nodes = node.children,
                    level = level + 1,
                    onItemClick = onItemClick,
                    onLongPress = onLongPress
                )
            }
        }
    }
}