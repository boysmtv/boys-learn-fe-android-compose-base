package com.movie.compose.feature.music.feature.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.core.network.config.NetworkConfig
import com.movie.compose.core.ui.R
import com.movie.compose.domain.model.DomainMusic
import com.movie.compose.feature.music.model.MusicItem
import com.movie.compose.feature.music.ui.MusicListUiEvent
import com.movie.compose.feature.music.ui.MusicListUiState

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val state by viewModel.uiState.collectAsState()

    val sampleMusicList = listOf(
        MusicItem("The Nights", "Avicii", R.drawable.ic_search),
        MusicItem("Blinding Lights", "The Weeknd", R.drawable.ic_setting),
        MusicItem("Heat Waves", "Glass Animals", R.drawable.ic_menu),
        MusicItem("Stay", "Justin Bieber", R.drawable.ic_profile)
    )

    LaunchedEffect(Unit) {
        val request = NetworkMusicRequest().apply { term = "justin bieber" }
        viewModel.loadMovies(request)

        viewModel.event.collect { event ->
            when (event) {
                is MusicListUiEvent.ShowToast ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                is MusicListUiEvent.NavigateToDetail ->
                    navController.navigate("detail/${event.movieId}")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    text = "Recommended for you",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(Modifier.height(12.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(sampleMusicList) { item ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(item.coverResId),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(MaterialTheme.shapes.medium)
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(item.title, color = Color.White, fontSize = 14.sp)
                            Text(item.artist, color = Color.Gray, fontSize = 12.sp)
                        }
                    }
                }
            }

            when {
                state.isLoading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .height(200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                state.error != null -> {
                    item {
                        Text(
                            text = "Error: ${state.error}",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.align(Alignment.CenterHorizontally as Alignment)
                        )
                    }
                }

                else -> {
                    items(state.musics) { music ->
                        MusicItemCard(music)
                    }
                }
            }
        }

        MiniPlayer()
    }
}

@Composable
private fun MusicItemCard(music: DomainMusic) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            music.artworkUrl100?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = music.trackName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .fillMaxHeight()
                )
            }

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                music.trackName?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = music.artistName ?: "Unknown Artist",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Track ID: ${music.trackId ?: "-"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}
