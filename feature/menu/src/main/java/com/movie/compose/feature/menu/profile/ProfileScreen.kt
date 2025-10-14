package com.movie.compose.feature.menu.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen() {
    Text("Profile Screen", modifier = Modifier.fillMaxSize(), style = MaterialTheme.typography.headlineMedium)
}