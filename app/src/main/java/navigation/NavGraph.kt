package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import presentation.ViewModel.CategoryViewModel
import presentation.ui.add.AddEditCategoryScreen
import presentation.ui.add.AddTaskScreen
import presentation.ui.show.NoteListScreen
import presentation.ui.show.ReminderListScreen
import presentation.ui.show.ScheduleListScreen
import presentation.ui.tasks.CategoryListScreen
import presentation.ui.tasks.TaskListScreen
import presentation.ui.category.AddEditCategoryScreen


// گراف ناوبری اصلی با بخش دسته‌بندی

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "categories",
        modifier = modifier)
    {
        composable("categories") {
            val vm: CategoryViewModel = hiltViewModel()
            CategoryListScreen(
                navController = navController,
                viewModel = vm,
                onAddClick = {
                    navController.navigate("add_category")
                },
                onEditClick = { categoryId ->
                    navController.navigate("add_category?categoryId=$categoryId")
                }
            )
        }

        composable(
            route = "add_edit_category?categoryId={categoryId}",
            arguments = listOf(navArgument("categoryId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: -1
            val viewModel: CategoryViewModel = hiltViewModel()
            val categories by viewModel.categories.collectAsState()
            val category = categories.find { it.id == categoryId }

            AddEditCategoryScreen(
                category = category, // ✅ این درسته
                viewModel = viewModel,
                onSave = { navController.popBackStack() }
            )
        }
        composable("edit_category/{categoryId}",
            arguments = listOf(navArgument("categoryId") {
                type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("categoryId")
            AddEditCategoryScreen(navController, categoryId = id)
        }



        composable("tasks") { TaskListScreen(navController) }
        composable("schedules") { ScheduleListScreen(navController) }
        composable("activities") { }
        composable("reminders") { ReminderListScreen(navController) }
        composable("notes") { NoteListScreen(navController) }
        composable("add_task") { AddTaskScreen(navController) }
        composable("add_category") {AddEditCategoryScreen(navController)}

    }
}