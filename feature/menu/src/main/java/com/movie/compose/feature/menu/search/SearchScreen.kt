package com.movie.compose.feature.menu.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen() {
    Text("Search Screen", modifier = Modifier.fillMaxSize(), style = MaterialTheme.typography.headlineMedium)
}