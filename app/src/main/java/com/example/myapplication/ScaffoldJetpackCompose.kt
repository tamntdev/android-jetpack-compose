@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {
    var counter by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            /**
             * Top app bar
             * Có 4 loại top app bar:
             * Nhỏ: dùng cho các màn hình không yêu cầu nhiều thao tác điều hướng hoặc hành động.
             * Căn giữa: dành cho các màn hình chỉ có đơn chức năng, đơn hành động.
             * Trung bình: dành cho các màn hình yêu cầu một lượng vừa phải các chức năng và hành vi điều hướng.
             * Lớn: dành cho các màn hình có nhiều chức năng và hành vi điều hướng.
             *
             * Các tham số phổ biến của 4 loại top app bar kể trên:
             * title: văn bản thể hiện tiêu đề của thanh ứng dụng.
             * navigationIcon: biểu tượng chính cho điều hướng. Xuất hiện ở góc trái thanh ứng dụng, có thể là dạng menu drawer hoặc nút up như trên.
             * actions: các biểu tượng cung cấp cho người dùng truy cập vào các hành động, xuất hiện ở bên phải thanh ứng dụng.
             * scrollBehavior: xác định cách thức thanh ứng dụng trên đỉnh màn hình phản hồi lại với việc cuộn nội dung bên trong Scaffold.
             * colors: xác định cách thức thanh ứng dụng xuất hiện trên màn hình.
             *
             *
             * Về hành vi cuộn của top app bar: ta có thể điều khiển hành vi cuộn bằng cách tạo lập đối tượng của TopAppBarScrollBehavior và truyền vào tham số scrollBehavior của TopAppBar. Có ba kiểu phản hồi với hành vi cuộn nội dung trong Scaffold của thanh top app bar:
             * enterAlwaysScrollBehavior: khi người dùng kéo nội dung bên trong Scaffold để nó cuộn lên, thanh top app bar sẽ co lại. Khi người dùng cuộn nội dung xuống, thanh top app bar sẽ mở rộng ra.
             * exitUntilCollapsedScrollBehavior: tương tự như trên nhưng thanh app bar vẫn sẽ xuất hiện và mở rộng khi người dùng cuộn tới cuối nội dung trong Scaffold.
             * pinnedScrollBehavior: thanh ứng dụng trên top không ảnh hưởng bởi sự kiện cuộn nội dung trong Scaffold.
             */
            TopAppBar(
                title = { Text("Top app bar") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    text = "Bottom app bar",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello, You have pressed the + button $counter times",
                modifier = Modifier.padding(top = 8.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Enter your name") },
                modifier = Modifier
                    .padding(start = 24.dp, top = 8.dp, end = 24.dp)
                    .fillMaxWidth()
            )
            Button(onClick = { counter++ }, modifier = Modifier.padding(top = 24.dp)) {
                Text(text = "Click Me")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarSample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top app bar") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val range = 1..100

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(range.count()) { index ->
            Text(text = "- List item number ${index + 1}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignTopAppBarSample() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Centered top app bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Up icon"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu icon"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumTopAppBarSample() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
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
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Up icon"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu icon"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarSample() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        "Large top app bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu icon"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            // để sử dụng được icon này bạn cần implement material extended
                            // dependency: "androidx.compose.material:material-icons-extended:1.7.8"
                            imageVector = Icons.Filled.AttachFile,
                            contentDescription = "Attach file icon"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.CalendarToday,
                            contentDescription = "Calendar icon"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "More icon"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Mic,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Image,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        }
    ) { innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldSamplePreview() {
    ScaffoldSample()
}