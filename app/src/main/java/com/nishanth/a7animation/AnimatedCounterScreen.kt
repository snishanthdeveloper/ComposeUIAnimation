package com.nishanth.a7animation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nishanth.a7animation.animation.AnimatedCounter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounterScreen() {
    // Our familiar state for the counter
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Our new animated counter composable
        AnimatedCounter(count = count)

        Spacer(modifier = Modifier.height(32.dp)) // Add some space

        Button(
            onClick = { count++ },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Increment Count")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimatedCounterPreview() {
    AnimatedCounterScreen()
}