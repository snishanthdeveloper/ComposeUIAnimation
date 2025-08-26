package com.nishanth.a7animation.animation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrossfadeTabs(selected: String, onSelect: (String) -> Unit) {
    val tabs = listOf("Home", "Profile")
    Column {
        Row {
            tabs.forEach { tab ->
                Text(
                    text = tab,
                    modifier = Modifier
                        .clickable { onSelect(tab) }
                        .padding(12.dp)
                )
            }
        }
        Crossfade(targetState = selected, animationSpec = tween(450)) { state ->
            when (state) {
                "Home" -> Text("🏠 Home Screen", style = MaterialTheme.typography.headlineMedium)
                "Profile" -> Text("👤 Profile Screen", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}
