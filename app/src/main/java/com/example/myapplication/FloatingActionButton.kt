package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatActionButtonSample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Floating action button"
            )
        }

        SmallFloatingActionButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = "Floating action button"
            )
        }

        LargeFloatingActionButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = "Floating action button"
            )
        }

        ExtendedFloatingActionButton(onClick = {},
            shape = RoundedCornerShape(12.dp), icon = {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Floating action button"
                )
            }, text = {
                Text("Edit profile")
            })
    }
}

@Preview
@Composable
fun FloatActionButtonSamplePreview() {
    FloatActionButtonSample()
}