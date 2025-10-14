package com.movie.compose.feature.music

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.movie.compose.core.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicTopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth()
            .height(56.dp)
            .background(Color.Black)
            .padding(horizontal = 16.dp)
        ,
        title = {
            Text(
                text = "Music",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_setting), contentDescription = null, tint = Color.White)
            }
            IconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_search), contentDescription = null, tint = Color.White)
            }
            IconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_profile), contentDescription = null, tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}