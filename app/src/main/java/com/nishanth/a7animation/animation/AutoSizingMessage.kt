package com.nishanth.a7animation.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AutoSizingMessage(text: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(12.dp)
            .animateContentSize(animationSpec = spring(dampingRatio = 0.7f))
    ) {
        Text(text)
    }
}

// A preview to show it in action
@Preview(showBackground = true)
@Composable
fun AutoSizingMessagePreview() {
    AutoSizingMessage(text = "Hello, this is a short message!")
}

// You can test with a longer string to see the animation
@Preview(showBackground = true)
@Composable
fun AutoSizingLongMessagePreview() {
    AutoSizingMessage(text = "This is a much longer message that will cause the box to smoothly expand. Watch how it gracefully resizes to fit all of this new content without any sudden jumps!")
}
