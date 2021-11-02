package com.rmakiyama.bokuju.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.rmakiyama.bokuju.ui.R

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String?,
) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                placeholder(R.drawable.image_placeholder)
            }
        ),
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
    )
}
