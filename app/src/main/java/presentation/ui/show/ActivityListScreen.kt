package presentation.ui.show

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import presentation.ViewModel.ActivityViewModel


@Composable
fun ActivityListScreen(vm: ActivityViewModel = viewModel()) {
    val list by vm.activities.collectAsStateWithLifecycle(emptyList())
    LazyColumn { items(list) { a -> Text(a.name) } }
}