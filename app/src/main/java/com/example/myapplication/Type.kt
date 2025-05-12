package com.example.myapplication

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

// Khai báo các font family cho app
val beVietnamPro = FontFamily(
    Font(R.font.be_vietnam_pro_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.be_vietnam_pro_medium, FontWeight.Light, FontStyle.Normal),
    Font(R.font.be_vietnam_pro_regular, FontWeight.Light, FontStyle.Normal),
    Font(R.font.be_vietnam_pro_bold, FontWeight.Light, FontStyle.Normal),
    Font(R.font.be_vietnam_pro_italic, FontWeight.Light, FontStyle.Italic),
)
private val light = Font(R.font.be_vietnam_pro_light, FontWeight.W300)
private val regular = Font(R.font.be_vietnam_pro_regular, FontWeight.W400)
private val medium = Font(R.font.be_vietnam_pro_medium, FontWeight.W500)
private val bold = Font(R.font.be_vietnam_pro_bold, FontWeight.W600)

// Create a font family to use in TextStyles
private val craneFontFamily = FontFamily(light, regular, medium, bold)

// Use the font family to define a custom typography
val craneTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = craneFontFamily
    ) /* ... */
)

// Pass the typography to a MaterialTheme that will create a theme using
// that typography in the part of the UI hierarchy where this theme is used
@Composable
fun CraneTheme(content: @Composable () -> Unit) {
    MaterialTheme(typography = craneTypography) {
        content()
    }
}