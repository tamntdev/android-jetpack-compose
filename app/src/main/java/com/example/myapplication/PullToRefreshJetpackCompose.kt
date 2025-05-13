package com.example.myapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PullToRefreshBasicSampleView() {
    // Danh sách mẫu
    var items by remember { mutableStateOf(listOf("Item 1", "Item 2", "Item 3")) }
    // Trạng thái làm mới
    var isRefreshing by remember { mutableStateOf(false) }

    PullToRefreshBasicSample(
        items = items,
        isRefreshing = isRefreshing,
        onRefresh = {
            // Giả lập hành động làm mới (ví dụ: tải dữ liệu mới)
            isRefreshing = true
            // Dùng coroutine để giả lập độ trễ
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000) // Giả lập tải dữ liệu trong 2 giây
                // Cập nhật danh sách (thêm mục mới hoặc làm mới dữ liệu)
                items = items + "Item ${items.size + 1}"
                isRefreshing = false
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshBasicSample(
    items: List<String>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(items) {
                ListItem({ Text(text = it) })
            }
        }
    }
}