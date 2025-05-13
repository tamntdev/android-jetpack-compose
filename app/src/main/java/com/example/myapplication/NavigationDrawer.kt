package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Start
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Navigation drawer là một thành phần menu trượt cho phép người dùng điều hướng tới các phần khác
 * nhau trong ứng dụng. Người dùng có thể kích hoạt menu này bằng cách nhấn vào biểu tượng menu
 * hoặc vuốt từ cạnh trái màn hình sang phải trong ứng dụng.
 * Các trường hợp sử dụng navigation drawer:
 * Trình bày nội dung: cho phép người dùng chuyển đổi qua lại giữa các mục khác nhau trong ứng dụng,
 * ví dụ trong ứng dụng nhắn tin, gửi mail, báo chí.
 * Quản lý tài khoản: cung cấp liên kết nhanh tới phần cài đặt tài khoản và hồ sơ cá nhấn trong ứng dụng.
 * Khám phá các tính năng của ứng dụng: gom nhóm nhiều tính năng và cài đặt trong một menu đơn để
 * tạo điều kiện cho người dùng khám phá và truy cập trong các ứng dụng phức tạp.
 *
 * Trong Material Design có hai kiểu navigation drawer:
 * - Chuẩn: chia sẻ chung không gian trên cùng một màn hình với các nội dung khác.
 * - Modal: xuất hiện trên top của các nội dung khác ở một màn hình độc lập.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerSample() {
    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed) // Để quản lý trạng thái mở/đóng drawer
    val scrollBehavior =
        TopAppBarDefaults.enterAlwaysScrollBehavior() // Để kích hoạt scroll behavior
    val scope = rememberCoroutineScope() // Tạo một scope để quản lý các coroutine đóng/mở drawer

    /**
     * Quản lý hành động
     * - Để quản lý cách thức đóng hay mở drawer, sử dụng DrawerState.
     * Khuyến nghị ta truyền DrawerState vào ModalNavigationDrawer sử dụng tham số drawerState.
     *
     * - DrawerState cung cấp truy cập tới hàm open() và close() cũng như các thuộc tính liên
     * quan tới trạng thái hiện tại của drawer.
     *
     * - Hàm open(), close() là các hàm suspend nên phải đặt trong một CoroutineScope.
     * Ta tạo ra scope này bằng cách sử dụng rememberCoroutineScope.
     */
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    "Mail",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                NavigationDrawerItem(
                    label = { Text("Inbox") },
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Inbox,
                            contentDescription = "Inbox icon"
                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Starred") },
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Start,
                            contentDescription = "Starred icon"
                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Send email") },
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.Send,
                            contentDescription = "Send icon"
                        )
                    }
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Settings") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings icon"
                        )
                    },
                    selected = false,
                    onClick = {}
                )
                NavigationDrawerItem(
                    label = { Text(text = "Dark mode") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.DarkMode,
                            contentDescription = "Dark mode icon"
                        )
                    },
                    selected = false,
                    onClick = {}
                )
            }
        },
        gesturesEnabled = true // Cho phép vuốt để đóng mở drawer
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                MediumTopAppBar(
                    title = {
                        Text(
                            "Medium top app bar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { // Gọi coroutine scope thực thi khi click vào icon
                                drawerState.apply { // Lấy thuộc tính của drawerState
                                    if (isClosed) open() else close() // Đóng mở drawer theo state
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu icon"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.AttachFile,
                                contentDescription = "Attach icon"
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.CalendarToday,
                                contentDescription = "Calendar icon"
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "More icon"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            ScrollContentView(innerPadding)
        }
    }
}

@Composable
fun ScrollContentView(paddingValues: PaddingValues) {
    val rangeValue = 1..100

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(rangeValue.count()) { index ->
            Text(text = "- List item number ${index + 1}")
        }
    }
}

@Preview
@Composable
fun NavigationDrawerSamplePreview() {
    NavigationDrawerSample()
}