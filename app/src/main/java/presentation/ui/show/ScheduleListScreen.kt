package presentation.ui.show

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import presentation.ViewModel.ScheduleViewModel

@Composable
fun ScheduleListScreen(navController: NavController, vm: ScheduleViewModel = viewModel()) {
    val list by vm.schedules.collectAsStateWithLifecycle(emptyList())
    LazyColumn { items(list) { s -> Text(s.name) } }
}