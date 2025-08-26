package com.nishanth.a7animation.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteHeart(isFav: Boolean) {
    val scale by animateFloatAsState(
        targetValue = if (isFav) 1.2f else 1f,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "heartScale"
    )
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = null,
        modifier = Modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .size(28.dp),
        tint = if (isFav) MaterialTheme.colorScheme.error else LocalContentColor.current
    )
}
