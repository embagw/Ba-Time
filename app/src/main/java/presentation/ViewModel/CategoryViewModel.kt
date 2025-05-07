package presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.embag.batime.data.local.Category
import com.embag.batime.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//  ViewModel مدیریت دسته‌بندی‌ها
//  @param repo مخزن داده‌ها

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repo: CategoryRepository
) : ViewModel() {
    // وضعیت لیست دسته‌بندی‌ها
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()

    init {
        // هنگام ساخته‌شدن ViewModel، جریان داده‌ها را جمع‌آوری کن
        viewModelScope.launch {
            repo.getCategories().collect { _categories.value = it }
        }
    }
    // افزودن دسته‌بندی جدید با نام و رنگ

    fun addCategory(name: String, color: Long) = viewModelScope.launch {
        repo.addCategory(Category(name = name, color = color))
    }
}


