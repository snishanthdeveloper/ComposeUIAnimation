package com.nishanth.a7animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nishanth.a7animation.animation.AnimatedCounter
import com.nishanth.a7animation.animation.AnimatedList
import com.nishanth.a7animation.animation.AutoSizingMessage
import com.nishanth.a7animation.animation.CrossfadeTabs
import com.nishanth.a7animation.animation.DotsLoader
import com.nishanth.a7animation.animation.ExpandableCard
import com.nishanth.a7animation.animation.FavoriteHeart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme { DemoScreen() } }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScreen() {
    var tab by remember { mutableStateOf("Home") }
    var expanded by remember { mutableStateOf(false) }
    var fav by remember { mutableStateOf(false) }
    var count by remember { mutableStateOf(0) }
    var list by remember { mutableStateOf(listOf("Alpha", "Beta", "Gamma")) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Compose Animation Demo") }, actions = {
                IconButton(onClick = { fav = !fav }) {
                    FavoriteHeart(fav)
                }
            })
        }) { padding ->
        Column(
            Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1) Crossfade between tabs
            CrossfadeTabs(selected = tab, onSelect = { tab = it })

            // 2) Expandable card
            ExpandableCard(
                title = "What is Motion for?",
                content = "Hierarchy, feedback, and delight. Keep it purposeful and fast."
            )

            // 3) Auto-sizing message
            AutoSizingMessage(
                text = if (expanded) "This block auto-animates its size. Toggle below to change content length."
                else "Short text."
            )

            // Toggle for content size
            Button(onClick = { expanded = !expanded }) {
                Text(if (expanded) "Show less" else "Show more")
            }

            // 4+5) Counter with AnimatedContent
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = { if (count > 0) count-- }) { Text("-") }
                Spacer(Modifier.width(12.dp))
                AnimatedCounter(count)
                Spacer(Modifier.width(12.dp))
                Button(onClick = { count++ }) { Text("+") }
            }

            // 6) Infinite loader
            DotsLoader()

            // 7) Animated list re-order
            Button(onClick = { list = list.shuffled() }) { Text("Shuffle list") }
            Box(Modifier.height(300.dp)) {
                AnimatedList(list)
            }
        }
    }
}
