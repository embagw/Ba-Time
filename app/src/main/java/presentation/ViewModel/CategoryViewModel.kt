package presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.embag.batime.data.local.Category
import com.embag.batime.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

//  ViewModel مدیریت دسته‌بندی‌ها
//  @param repo مخزن داده‌ها

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repo: CategoryRepository
) : ViewModel() {

    val categories = repo.getAll()
        .map { it.sortedBy { c -> c.name } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addCategory(category: Category) = viewModelScope.launch {
        repo.add(category)
    }

    fun updateCategory(category: Category) = viewModelScope.launch {
        repo.update(category)
    }

    fun deleteCategory(category: Category) = viewModelScope.launch {
        repo.delete(category)
    }
}


