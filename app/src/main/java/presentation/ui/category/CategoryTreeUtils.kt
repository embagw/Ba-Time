package presentation.ui.category

import com.embag.batime.data.local.Category

data class CategoryNode(
    val category: Category,
    val children: List<CategoryNode>
)

fun buildTree(categories: List<Category>): List<CategoryNode> {
    val map = categories.associateBy { it.id }.mapValues { mutableListOf<CategoryNode>() }
    val roots = mutableListOf<CategoryNode>()
    // ایجاد CategoryNode بدون فرزندان
    val nodes = categories.map { CategoryNode(it, map[it.id]!!) }

    // اتصال فرزندان
    nodes.forEach { node ->
        val pid = node.category.parentId
        if (pid != null && map.containsKey(pid)) {
            map[pid]!!.add(node)
        } else {
            roots.add(node)
        }
    }
    return roots
}