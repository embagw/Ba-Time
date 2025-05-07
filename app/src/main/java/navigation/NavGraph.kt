package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import presentation.ui.tasks.CategoryListScreen

// گراف ناوبری اصلی با بخش دسته‌بندی

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "categories") {
        composable("categories") { CategoryListScreen() }
        composable("tasks") { TaskListScreen() }
        composable("schedules") { TaskListScreen() }
        composable("activities") { TaskListScreen() }
        composable("reminders") { TaskListScreen() }
        composable("notes") { TaskListScreen() }

    }
}