package com.movie.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.movie.compose.feature.movie.list.ui.MovieListScreen

@Composable
fun MovieComposeApp() {
    MaterialTheme {
        Surface(modifier = Modifier) {
            MovieListScreen()
        }
    }
}
