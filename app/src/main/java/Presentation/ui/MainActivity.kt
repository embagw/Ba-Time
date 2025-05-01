package Presentation.ui

import Presentation.ViewModel.TodoViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import Presentation.theme.BaTimeTheme
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.embag.batime.data.database.TodoDatabase

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            name = "todo_database"
        ).build()
    }
    private val viewModel by viewModels<TodoViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TodoViewModel(db.dao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaTimeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AddTodoBottomBar(viewModel=viewModel)
                    }) { innerPadding ->

                }
            }
        }
    }
}
