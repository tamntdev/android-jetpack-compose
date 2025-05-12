package com.example.myapplication

import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun TextFieldScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldSample()
        OutlinedTextFieldSample()
        BasicTextFieldSample()
        PasswordTextField()
        NoLeadingZero()
    }
}


@Composable
private fun TextFieldSample() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val rainbowColors: List<Color> = listOf(
        Color(0xFFFF0000), // Red - đỏ
        Color(0xFFFF7F00), // Orange - cam
        Color(0xFFFFFF00), // Yellow - vàng
        Color(0xFF00FF00), // Green - lục
        Color(0xFF0000FF), // Blue - lam
        Color(0xFF4B0082), // Indigo - chàm
        Color(0xFF9400D3)  // Violet - tím
    )
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("This is a text field") },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            brush = brush // chỉ cần gắn thuộc tính brush như này là ok
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
private fun OutlinedTextFieldSample() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text, onValueChange = { text = it },
        label = { Text("This is an outlined text field") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@Composable
private fun BasicTextFieldSample() {
    var text by rememberSaveable {
        mutableStateOf("This is a basic text field")
    }
    BasicTextField(
        value = text, onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PasswordTextField() {
    val state = remember { TextFieldState() }
    var showPassword by remember { mutableStateOf(false) }
    BasicSecureTextField(
        state = state,
        textObfuscationMode =
        if (showPassword) {
            TextObfuscationMode.Visible
        } else {
            TextObfuscationMode.RevealLastTyped
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp))
            .padding(6.dp),
        decorator = { innerTextField ->
            Box(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp, end = 48.dp)
                ) {
                    innerTextField()
                }
                Icon(
                    if (showPassword) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    },
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .requiredSize(48.dp).padding(16.dp)
                        .clickable { showPassword = !showPassword }
                )
            }
        }
    )
}

@Composable
private fun NoLeadingZero() {
    var input by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = input,
        onValueChange = { newValue ->
            input = newValue.trimStart { it == '0' || it == ' ' }
        },
        label = { Text("Enter a number") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldScreenPreview() {
    MyApplicationTheme() {
        val modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
        TextFieldScreen(modifier)
    }
}