package com.movie.compose.feature.music

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.movie.compose.core.ui.R

@Composable
fun MusicBottomBar() {
    NavigationBar(
        containerColor = Color.Black
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(painterResource(R.drawable.ic_home), null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(painterResource(R.drawable.ic_search), null) },
            label = { Text("Explore") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(painterResource(R.drawable.ic_favorite), null) },
            label = { Text("Library") }
        )
    }
}
