package com.example.myapplication

import android.app.Dialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * - Dialog là một thành phần cơ bản không cung cấp sẵn bất kì style hay slot chờ sẵn nào cho nội
 * dung bên trong nó. Ta thường sử dụng Dialog kết hợp với Card.
 * - Sau đây là một số tham số chính của dialog:
 *      + onDismissRequest: biểu thức lambda được gọi khi người dùng đóng hộp thoại.
 *      + properties: một đối tượng của DialogProperties cung cấp một số phạm vi bổ sung cho
 *      việc tùy biến  hộp thoại.
 */
@Composable
fun DialogSample() {
    var openAlertDialog by remember { mutableStateOf(false) }

    var isShowDialog by remember { mutableStateOf(false) }

    if (isShowDialog) {
        DialogScreen(onDismiss = { isShowDialog = false })
    }

    if (openAlertDialog) {
        AlertDialogExample(
            onConfirmation = {
                openAlertDialog = false
            },
            onDismissRequest = {
                openAlertDialog = false
            },
            dialogTitle = "Alert dialog",
            dialogText = "This is an alert dialog",
            icon = Icons.Filled.Warning
        )
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButton(onClick = {
                isShowDialog = true
            }, modifier = Modifier.padding(innerPadding)) {
                Text(text = "Show dialog")
            }

            ElevatedButton(onClick = {
                openAlertDialog = true
            }) {
                Text("Show alert dialog")
            }
        }
    }
}

@Composable
fun DialogScreen(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(all = 16.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            border = BorderStroke(
                width = 2.dp, Color(0xFF01579B)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
        ) {
            Text(
                text = "Hello from dialog",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Image(
                painter = painterResource(R.drawable.logo_android_studio),
                contentDescription = "Android Studio image",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Dismiss")
                }
                TextButton(
                    onClick = {/* todo */ },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Confirm")
                }
            }
        }
    }
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Preview
@Composable
fun DialogSamplePreview() {
    DialogSample()
}