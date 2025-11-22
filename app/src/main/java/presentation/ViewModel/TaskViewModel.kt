package presentation.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.embag.batime.data.local.Task
import com.embag.batime.data.repository.TaskRepository
import com.embag.batime.data.repository.TaskRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TaskViewModel @Inject constructor(
    savedState: SavedStateHandle,
    private val repo: TaskRepository
): ViewModel() {
    private val catId: Int = checkNotNull(savedState.get<Int>("categoryId"))
    val tasks = repo.getTasks(catId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun add(t: Task) = viewModelScope.launch { repo.addTask(t) }
    fun update(t: Task) = viewModelScope.launch { repo.updateTask(t) }
    fun delete(t: Task) = viewModelScope.launch { repo.deleteTask(t) }
}
//@HiltViewModel
//class TaskViewModel @Inject constructor(
//    private val repo: TaskRepositoryImpl) : ViewModel() {
//    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
//    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()
//    init { viewModelScope.launch { repo.getAll().collect { _tasks.value = it } } }
//    fun add(task: Task) = viewModelScope.launch { repo.add(task) }
//}

