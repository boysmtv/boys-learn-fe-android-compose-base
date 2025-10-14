package com.movie.compose.feature.music

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterChipsRow() {
    val filters = listOf("Feel good", "Energize", "Commute", "Relax", "Sad")
    LazyRow(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        items(filters) { label ->
            AssistChip(
                onClick = {},
                label = { Text(label) },
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}
