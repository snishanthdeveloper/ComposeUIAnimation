package com.nishanth.a7animation.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


// The core AnimatedCounter composable
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(count: Int) {
    AnimatedContent(
        targetState = count, // The state that triggers the animation
        transitionSpec = {
            // Define the transition for entering and exiting content
            // slideInVertically: New content slides in from the bottom
            // fadeIn: New content fades in
            // togetherWith: Combines the exit transition for old content
            // slideOutVertically: Old content slides out to the top
            // fadeOut: Old content fades out
            slideInVertically { it } + fadeIn() togetherWith
                    slideOutVertically { -it } + fadeOut()
        },
        label = "counter" // A label for debugging and accessibility
    ) { value ->
        // This lambda defines the content to display for the current 'value'
        Text("$value", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedCounterPreview() {
    AnimatedCounter(3)
}
