package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardSample() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer, // Màu nền cho Card
                    contentColor = MaterialTheme.colorScheme.primary // Màu nội dung trong card
                ),
                onClick = {
                    // Xử lý sự kiện khi Card được nhấn
                    Log.d("Card click", "Card was clicked!")
                },
                enabled = true, // Đặt chế độ kích hoạt cho Card
                elevation = CardDefaults.cardElevation( // Chỉnh elevation cho Card
                    defaultElevation = 6.dp,
                    pressedElevation = 8.dp
                )
            ) {
                Text(
                    "Hello, Jetpack Compose",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Example image",
                    modifier = Modifier
                        .padding(all = 12.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
            ) {
                Text(
                    text = "Elevated",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                shape = RoundedCornerShape(corner = CornerSize(32.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                border = BorderStroke(width = 2.dp, Color.Green),
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
            ) {
                Text(
                    text = "Hello, I am a cat",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(R.drawable.logo_xcode),
                    contentDescription = "Cat image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview
@Composable
fun CardSamplePreview() {
    CardSample()
}