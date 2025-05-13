package com.example.myapplication

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HorizontalMultiBrowseCarouselSample() {

    @SuppressLint("SupportAnnotationUsage")
    data class CarouselItem(
        val id: Int,
        @DrawableRes val imageResId: Int,
        @StringRes val contentDescriptionResId: Int
    )

    val items =
        listOf(
            CarouselItem(0, R.drawable.logo_android_studio, R.string.android_studio),
            CarouselItem(1, R.drawable.logo_xcode, R.string.xcode),
            CarouselItem(2, R.drawable.ic_android, R.string.icon_android),
            CarouselItem(4, R.drawable.logo_android_studio, R.string.android_studio),
        )

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier.fillMaxWidth().height(221.dp),
        preferredItemWidth = 186.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = items[i]
        Image(
            modifier = Modifier.fillMaxWidth().height(205.dp).maskClip(MaterialTheme.shapes.extraLarge),
            painter = painterResource(id = item.imageResId),
            contentDescription = stringResource(item.contentDescriptionResId),
            contentScale = ContentScale.FillWidth
        )
    }
}