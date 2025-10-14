package com.movie.compose.feature.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie.compose.core.ui.R
import com.movie.compose.feature.music.toolbar.AppToolbar

@Composable
fun MusicScreen() {
    val backgroundColor = Color.Black
    val toolbarColor = Color.Black
    val textColor = Color.White
    val secondaryText = Color.Gray

    val sampleMusicList = listOf(
        MusicItem("The Nights", "Avicii", R.drawable.ic_search),
        MusicItem("Blinding Lights", "The Weeknd", R.drawable.ic_setting),
        MusicItem("Heat Waves", "Glass Animals", R.drawable.ic_menu),
        MusicItem("Stay", "Justin Bieber", R.drawable.ic_profile)
    )

    Scaffold(
        topBar = {
            AppToolbar(
                onSearchClick = { /* open search */ },
                onSettingsClick = { /* open settings */ }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(toolbarColor)
                    .height(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    Icon(painterResource(R.drawable.ic_home), null, tint = textColor)
                    Icon(painterResource(R.drawable.ic_movie), null, tint = textColor)
                    Icon(painterResource(R.drawable.ic_setting), null, tint = textColor)
                    Icon(painterResource(R.drawable.ic_favorite), null, tint = textColor)
                }
            }
        },
        containerColor = backgroundColor
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text("Recommended for you", color = textColor, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(12.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(sampleMusicList) { item ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(item.coverResId),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(item.title, color = textColor, fontSize = 14.sp)
                            Text(item.artist, color = secondaryText, fontSize = 12.sp)
                        }
                    }
                }
                Spacer(Modifier.height(120.dp))
            }

            MiniPlayer()
        }
    }
}